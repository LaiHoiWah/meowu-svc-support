package com.meowu.svc.support.core.dictionary.service;

import com.meowu.svc.support.core.dictionary.entity.Dictionary;

import java.util.List;

public interface DictionaryService{

    Dictionary save(Dictionary dictionary);

    Dictionary getById(Long id);

    List<Dictionary> findByGroupId(Long groupId);
}
