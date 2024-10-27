package com.meowu.svc.support.core.dictionary.dao;

import com.meowu.starter.commons.security.constants.RecordStatus;
import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.commons.utils.StringUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.mysql.restrictions.Restrictions;
import com.meowu.starter.mybatis.security.exception.DataAccessException;
import com.meowu.svc.support.core.dictionary.dao.mapper.GroupMapper;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class GroupDao{

    @Autowired
    private GroupMapper groupMapper;

    public Group save(Group group){
        AssertionUtils.notNull(group, "Group entity must not be null");
        AssertionUtils.notBlank(group.getCode(), "Group code must not be null");

        try{
            // set create time
            group.setCreateTime(new Date());
            groupMapper.save(group);
            return group;
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public Group getById(Long id){
        AssertionUtils.notNull(id, "Group id must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Group.class);
            criteria.where(Restrictions.equal("id", id));
            return groupMapper.get(criteria);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<Group> find(String keyword, RecordStatus status){
        try{
            Criteria criteria = new Criteria();
            criteria.from(Group.class);

            // condition
            if(StringUtils.isNotBlank(keyword)){
                criteria.where(Restrictions.like("code", StringUtils.strip(keyword)));
            }
            if(status != null){
                criteria.where(Restrictions.equal("status", status.getCode()));
            }
            return groupMapper.find(criteria);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public boolean existsByCode(String code){
        AssertionUtils.notBlank(code, "Group code must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Group.class);
            criteria.select(Restrictions.count("id"));
            criteria.where(Restrictions.equal("code", code));

            // result
            Long total = groupMapper.count(criteria);
            return (total != null && total > 0);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public boolean existsById(Long id){
        AssertionUtils.notNull(id, "Group id must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Group.class);
            criteria.select(Restrictions.count("id"));
            criteria.where(Restrictions.equal("id", id));

            // result
            Long total = groupMapper.count(criteria);
            return (total != null && total > 0);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}
