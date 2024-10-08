package com.meowu.svc.support.core.dictionary.service.impl;

import com.meowu.svc.support.core.dictionary.entity.Group;
import com.meowu.svc.support.core.dictionary.manager.GroupManager;
import com.meowu.svc.support.core.dictionary.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupManager groupManager;

    @Transactional
    @Override
    public Group save(Group group){
        return groupManager.save(group);
    }

    @Override
    public Group getById(Long id){
        return groupManager.getById(id);
    }

    @Override
    public List<Group> find(){
        return groupManager.find();
    }
}
