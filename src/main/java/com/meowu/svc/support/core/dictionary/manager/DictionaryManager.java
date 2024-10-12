package com.meowu.svc.support.core.dictionary.manager;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.security.exception.DuplicateException;
import com.meowu.starter.web.security.stereotype.Manager;
import com.meowu.svc.support.core.dictionary.dao.DictionaryDao;
import com.meowu.svc.support.core.dictionary.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Manager
public class DictionaryManager{

    @Autowired
    private DictionaryDao dictionaryDao;

    public Dictionary save(Dictionary dictionary){
        AssertionUtils.notNull(dictionary, "Dictionary entity must not be null");
        AssertionUtils.notNull(dictionary.getGroupId(), "Dictionary group id must not be null");
        AssertionUtils.notBlank(dictionary.getCode(), "Dictionary code must not be null");

        // exist


        if(dictionaryDao.existsByGroupIdAndCode(dictionary.getGroupId(), dictionary.getCode())){
            throw new DuplicateException("Dictionary code [" + dictionary.getCode() + "] is exists");
        }

        return dictionaryDao.save(dictionary);
    }

    public Dictionary getById(Long id){
        AssertionUtils.notNull(id, "Dictionary id must not be null");

        return dictionaryDao.getById(id);
    }

    public List<Dictionary> findByGroupId(Long groupId){
        AssertionUtils.notNull(groupId, "Dictionary group id must not be null");

        return dictionaryDao.findByGroupId(groupId);
    }
}
