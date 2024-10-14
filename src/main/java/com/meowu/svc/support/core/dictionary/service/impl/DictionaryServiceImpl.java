package com.meowu.svc.support.core.dictionary.service.impl;

import com.meowu.svc.support.core.dictionary.entity.Dictionary;
import com.meowu.svc.support.core.dictionary.manager.DictionaryManager;
import com.meowu.svc.support.core.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryManager dictionaryManager;

    @Transactional
    @Override
    public Dictionary save(Dictionary dictionary){
        return dictionaryManager.save(dictionary);
    }

    @Override
    public Dictionary getById(Long id){
        return dictionaryManager.getById(id);
    }

    @Override
    public List<Dictionary> findByGroupCode(String groupCode){
        return dictionaryManager.findByGroupCode(groupCode);
    }

    @Override
    public Map<String, List<Dictionary>> findByGroupCodes(List<String> groupCode){
        List<Dictionary> dictionaries = dictionaryManager.findByGroupCodes(groupCode);

        return dictionaries.stream()
                           .collect(Collectors.groupingBy(Dictionary::getGroupCode));
    }
}
