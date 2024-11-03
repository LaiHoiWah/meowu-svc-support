package com.meowu.svc.support.core.dictionary.service.impl;

import com.meowu.starter.commons.security.constants.RecordStatus;
import com.meowu.starter.commons.utils.CollectionUtils;
import com.meowu.starter.commons.utils.ObjectUtils;
import com.meowu.starter.commons.utils.StringUtils;
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
    public List<Group> find(String keyword, List<String> code, List<RecordStatus> status){
        String             strip      = null;
        List<String>       codeList   = null;
        List<RecordStatus> statusList = null;

        if(keyword != null){
            strip = StringUtils.strip(keyword);
        }
        if(CollectionUtils.isNotEmpty(code)){
            codeList = code.stream()
                           .filter(StringUtils::isNotBlank)
                           .map(StringUtils::strip)
                           .toList();
        }
        if(CollectionUtils.isNotEmpty(status)){
            statusList = status.stream()
                               .filter(ObjectUtils::isNotNull)
                               .toList();
        }

        return groupManager.find(strip, codeList, statusList);
    }
}
