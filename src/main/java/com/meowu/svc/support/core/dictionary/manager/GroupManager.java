package com.meowu.svc.support.core.dictionary.manager;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.web.security.stereotype.Manager;
import com.meowu.svc.support.core.dictionary.dao.GroupDao;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class GroupManager{

    @Autowired
    private GroupDao groupDao;

    public Group save(Group group){
        AssertionUtils.notNull(group, "Group must not be null");
        AssertionUtils.notBlank(group.getCode(), "Group code must not be null");

        // exist group code
        if(groupDao.existsByCode(group.getCode())){
            throw new IllegalArgumentException("Group code [" + group.getCode() + "] is exists");
        }

        return groupDao.save(group);
    }
}
