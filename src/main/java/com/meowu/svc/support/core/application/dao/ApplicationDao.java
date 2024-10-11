package com.meowu.svc.support.core.application.dao;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.mysql.restrictions.Restrictions;
import com.meowu.svc.support.core.application.dao.mapper.ApplicationMapper;
import com.meowu.svc.support.core.application.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ApplicationDao{

    @Autowired
    private ApplicationMapper applicationMapper;

    public Application save(Application application){
        AssertionUtils.notNull(application, "Application entity must not be null");
        AssertionUtils.notBlank(application.getName(), "Application name must not be null");
        AssertionUtils.notBlank(application.getIp(), "Application IP must not be null");
        AssertionUtils.notNull(application.getPort(), "Application port must not be null");

        // set create time
        application.setCreateTime(new Date());
        applicationMapper.save(application);
        return application;
    }

    public Application getById(Long id){
        AssertionUtils.notNull(id, "Application id must not be null");

        // condition
        Criteria criteria = new Criteria();
        criteria.from(Application.class);
        criteria.where(Restrictions.equal("id", id));
        return applicationMapper.get(criteria);
    }

    public List<Application> findByName(String name){
        AssertionUtils.notBlank(name, "Application name must not be null");

        // condition
        Criteria criteria = new Criteria();
        criteria.from(Application.class);
        criteria.where(Restrictions.equal("name", name));
        return applicationMapper.find(criteria);
    }

    public boolean existsByNameAndIpAndPort(String name, String ip, Integer port){
        AssertionUtils.notBlank(name, "Application name must not be null");
        AssertionUtils.notBlank(ip, "Application ip must not be null");
        AssertionUtils.notNull(port, "Application port must not be null");

        // condition
        Criteria criteria = new Criteria();
        criteria.from(Application.class);
        criteria.where(
            Restrictions.equal("name", name),
            Restrictions.equal("ip", ip),
            Restrictions.equal("port", port)
        );

        Long total = 0L;
        return (total != 0 && total > 0);
    }
}
