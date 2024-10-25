package com.meowu.svc.support.core.dictionary.dao.mapper;

import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.mysql.provider.Provider;
import com.meowu.svc.support.commons.mybatis.handler.RecordStatusHandler;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface GroupMapper{

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert(
        """
        INSERT INTO st_group (
            code,
            description,
            status,
            create_time
        ) VALUES (
            #{code, jdbcType=VARCHAR},
            #{description, jdbcType=VARCHAR},
            #{status, typeHandler=com.meowu.svc.support.commons.mybatis.handler.RecordStatusHandler},
            #{createTime, jdbcType=TIMESTAMP}
        )
        """
    )
    void save(Group group);

    @Results(value = {
        @Result(property = "id",          column = "id",          javaType = Long.class, id = true),
        @Result(property = "code",        column = "code",        javaType = String.class),
        @Result(property = "description", column = "description", javaType = String.class),
        @Result(property = "status",      column = "status",      typeHandler = RecordStatusHandler.class),
        @Result(property = "createTime",  column = "create_time", javaType = Date.class),
        @Result(property = "updateTime",  column = "update_time", javaType = Date.class),
        @Result(property = "deleteTime",  column = "delete_time", javaType = Date.class)
    })
    @SelectProvider(type = Provider.class, method = "find")
    Group get(Criteria criteria);

    @Results(value = {
        @Result(property = "id",          column = "id",          javaType = Long.class, id = true),
        @Result(property = "code",        column = "code",        javaType = String.class),
        @Result(property = "description", column = "description", javaType = String.class),
        @Result(property = "status",      column = "status",      typeHandler = RecordStatusHandler.class),
        @Result(property = "createTime",  column = "create_time", javaType = Date.class),
        @Result(property = "updateTime",  column = "update_time", javaType = Date.class),
        @Result(property = "deleteTime",  column = "delete_time", javaType = Date.class)
    })
    @SelectProvider(type = Provider.class, method = "find")
    List<Group> find(Criteria criteria);

    @ResultType(value = Long.class)
    @SelectProvider(type = Provider.class, method = "find")
    Long count(Criteria criteria);
}
