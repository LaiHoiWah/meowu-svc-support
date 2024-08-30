package com.meowu.svc.support.core.dictionary.dao.mapper;

import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.provider.MySqlProvider;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupMapper{

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into st_group(code, description, create_time) values(#{code}, #{description}, #{createTime})")
    void save(Group group);

    @SelectProvider(type = MySqlProvider.class, method = "find")
    Group get(Criteria criteria);

    @SelectProvider(type = MySqlProvider.class, method = "find")
    List<Group> find(Criteria criteria);

    @SelectProvider(type = MySqlProvider.class, method = "find")
    Long count(Criteria criteria);
}
