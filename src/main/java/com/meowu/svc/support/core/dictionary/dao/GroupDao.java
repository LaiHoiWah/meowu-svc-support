package com.meowu.svc.support.core.dictionary.dao;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.mysql.restrictions.Restrictions;
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

        // set create time
        group.setCreateTime(new Date());
        groupMapper.save(group);
        return group;
    }

    public Group getById(Long id){
        AssertionUtils.notNull(id, "Group id must not be null");

        // condition
        Criteria criteria = new Criteria();
        criteria.from(Group.class);
        criteria.where(Restrictions.equal("id", id));
        return groupMapper.get(criteria);
    }

    public List<Group> find(){
        Criteria criteria = new Criteria();
        criteria.from(Group.class);
        return groupMapper.find(criteria);
    }

    public boolean existsByCode(String code){
        AssertionUtils.notBlank(code, "Group code must not be null");

        // condition
        Criteria criteria = new Criteria();
        criteria.from(Group.class);
        criteria.select(Restrictions.count("id"));
        criteria.where(Restrictions.equal("code", code));

        // result
        Long total = groupMapper.count(criteria);
        return (total != null && total > 0);
    }
}
