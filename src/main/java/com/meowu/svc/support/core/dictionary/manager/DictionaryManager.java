package com.meowu.svc.support.core.dictionary.manager;

import com.meowu.starter.commons.security.exception.DuplicateException;
import com.meowu.starter.commons.security.exception.NotFoundException;
import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.commons.utils.StringUtils;
import com.meowu.starter.web.security.stereotype.Manager;
import com.meowu.svc.support.core.dictionary.dao.DictionaryDao;
import com.meowu.svc.support.core.dictionary.dao.GroupDao;
import com.meowu.svc.support.core.dictionary.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Manager
public class DictionaryManager{

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private GroupDao groupDao;

    public Dictionary save(Dictionary dictionary){
        AssertionUtils.notNull(dictionary, "Dictionary entity must not be null");
        AssertionUtils.notBlank(dictionary.getGroupCode(), "Dictionary group code must not be null");
        AssertionUtils.notBlank(dictionary.getCode(), "Dictionary code must not be null");

        // verify
        if(groupDao.existsByCode(dictionary.getGroupCode())){
            throw new NotFoundException("Group code [" + dictionary.getGroupCode() + "] is not exists");
        }
        if(dictionaryDao.existsByGroupCodeAndCode(dictionary.getGroupCode(), dictionary.getCode())){
            throw new DuplicateException("Dictionary code [" + dictionary.getCode() + "] is exists");
        }

        return dictionaryDao.save(dictionary);
    }

    public Dictionary getById(Long id){
        AssertionUtils.notNull(id, "Dictionary id must not be null");

        return dictionaryDao.getById(id);
    }

    public List<Dictionary> findByGroupCode(String groupCode){
        AssertionUtils.notNull(groupCode, "Dictionary group code must not be null");

        return dictionaryDao.findByGroupCode(groupCode);
    }

    public List<Dictionary> findByGroupCodes(List<String> groupCodes){
        AssertionUtils.notEmpty(groupCodes, "Dictionary group code list must not be null");

        // filter & strip
        groupCodes = groupCodes.stream()
                               .filter(StringUtils::isNotBlank)
                               .map(StringUtils::strip)
                               .collect(Collectors.toList());

        return dictionaryDao.findByGroupCodes(groupCodes);
    }
}
