package com.meowu.svc.support.core.dictionary.dao.mapper;

import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.provider.MySqlProvider;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupMapper{

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into st_group(name, description, create_time) values(#{name}, #{description}, #{createTime})")
    Group save(Group group);

    @SelectProvider(value = MySqlProvider.class, method = "find")
    Group get(@Param("criteria") Criteria criteria);

    @SelectProvider(value = MySqlProvider.class, method = "find")
    List<Group> find(@Param("criteria") Criteria criteria);
}
