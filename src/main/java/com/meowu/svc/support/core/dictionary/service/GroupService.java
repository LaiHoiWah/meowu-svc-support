package com.meowu.svc.support.core.dictionary.service;

import com.meowu.starter.commons.security.constants.RecordStatus;
import com.meowu.svc.support.core.dictionary.entity.Group;

import java.util.List;

public interface GroupService{

    Group save(Group group);

    Group getById(Long id);

    List<Group> find(String keyword, List<String> code, List<RecordStatus> status);
}
