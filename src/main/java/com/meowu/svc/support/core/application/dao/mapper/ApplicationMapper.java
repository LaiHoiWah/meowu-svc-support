package com.meowu.svc.support.core.application.dao.mapper;

import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.svc.support.core.application.entity.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper{

    void save(Application application);

    Application get(Criteria criteria);

    List<Application> find(Criteria criteria);
}
