package com.meowu.svc.support.core.dictionary.dao;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.criteria.Restrictions;
import com.meowu.svc.support.core.dictionary.dao.mapper.GroupMapper;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class GroupDao{

    @Autowired
    private GroupMapper groupMapper;

    public Group save(Group group){
        AssertionUtils.notNull(group, "Group entity must not be null");

        // set create time
        group.setCreateTime(new Date());
        return groupMapper.save(group);
    }

    public Group getById(Long id){
        AssertionUtils.notNull(id, "Group id must not be null");

        Criteria criteria = new Criteria();
        criteria.where(Restrictions.equal("id", id));
        return groupMapper.get(criteria);
    }
}
