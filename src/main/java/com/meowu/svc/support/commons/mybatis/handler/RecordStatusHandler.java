package com.meowu.svc.support.commons.mybatis.handler;

import com.meowu.starter.commons.security.constants.RecordStatus;
import com.meowu.starter.commons.utils.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordStatusHandler implements TypeHandler<RecordStatus>{

    @Override
    public void setParameter(PreparedStatement ps, int i, RecordStatus status, JdbcType jdbcType) throws SQLException{
        ps.setString(i, status == null ? null : status.getCode());
    }

    @Override
    public RecordStatus getResult(ResultSet rs, String columnName) throws SQLException{
        String code = rs.getString(columnName);
        return StringUtils.isNotBlank(code) ? RecordStatus.getByCode(code) : null;
    }

    @Override
    public RecordStatus getResult(ResultSet rs, int columnIndex) throws SQLException{
        String code = rs.getString(columnIndex);
        return StringUtils.isNotBlank(code) ? RecordStatus.getByCode(code) : null;
    }

    @Override
    public RecordStatus getResult(CallableStatement cs, int columnIndex) throws SQLException{
        String code = cs.getString(columnIndex);
        return StringUtils.isNotBlank(code) ? RecordStatus.getByCode(code) : null;
    }
}
