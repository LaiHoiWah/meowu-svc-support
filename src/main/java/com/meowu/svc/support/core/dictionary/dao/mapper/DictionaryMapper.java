package com.meowu.svc.support.core.dictionary.dao.mapper;

import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.mysql.provider.Provider;
import com.meowu.svc.support.commons.mybatis.handler.RecordStatusHandler;
import com.meowu.svc.support.core.dictionary.entity.Dictionary;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface DictionaryMapper{

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert(
        """
        INSERT INTO st_dictionary (group_code, code, display, description, status, create_time)
             VALUES (#{groupCode}, #{code}, #{display}, #{description}, #{status}, #{createTime})
        """
    )
    void save(Dictionary dictionary);

    @Results(value = {
        @Result(property = "id",          column = "id",          javaType = Long.class, id = true),
        @Result(property = "groupCode",   column = "group_code",  javaType = String.class),
        @Result(property = "code",        column = "code",        javaType = String.class),
        @Result(property = "display",     column = "display",     javaType = String.class),
        @Result(property = "description", column = "description", javaType = String.class),
        @Result(property = "status",      column = "status",      typeHandler = RecordStatusHandler.class),
        @Result(property = "createTime",  column = "create_time", javaType = Date.class),
        @Result(property = "updateTime",  column = "update_time", javaType = Date.class),
        @Result(property = "deleteTime",  column = "delete_time", javaType = Date.class)
    })
    @SelectProvider(type = Provider.class, method = "find")
    Dictionary get(Criteria criteria);

    @Results(value = {
        @Result(property = "id",          column = "id",          javaType = Long.class, id = true),
        @Result(property = "groupCode",   column = "group_code",  javaType = String.class),
        @Result(property = "code",        column = "code",        javaType = String.class),
        @Result(property = "display",     column = "display",     javaType = String.class),
        @Result(property = "description", column = "description", javaType = String.class),
        @Result(property = "status",      column = "status",      typeHandler = RecordStatusHandler.class),
        @Result(property = "createTime",  column = "create_time", javaType = Date.class),
        @Result(property = "updateTime",  column = "update_time", javaType = Date.class),
        @Result(property = "deleteTime",  column = "delete_time", javaType = Date.class)
    })
    @SelectProvider(type = Provider.class, method = "find")
    List<Dictionary> find(Criteria criteria);

    @ResultType(value = Long.class)
    @SelectProvider(type = Provider.class, method = "find")
    Long count(Criteria criteria);
}
