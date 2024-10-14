package com.meowu.svc.support.core.dictionary.dao;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.mysql.restrictions.Restrictions;
import com.meowu.starter.mybatis.security.exception.DataAccessException;
import com.meowu.svc.support.core.dictionary.dao.mapper.DictionaryMapper;
import com.meowu.svc.support.core.dictionary.entity.Dictionary;
import com.meowu.svc.support.core.dictionary.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class DictionaryDao{

    @Autowired
    private DictionaryMapper dictionaryMapper;

    public Dictionary save(Dictionary dictionary){
        AssertionUtils.notNull(dictionary, "Dictionary entity must not be null");
        AssertionUtils.notNull(dictionary.getGroupId(), "Dictionary group id must not be null");
        AssertionUtils.notBlank(dictionary.getCode(), "Dictionary code must not be null");

        try{
            // set create time
            dictionary.setCreateTime(new Date());
            dictionaryMapper.save(dictionary);
            return dictionary;
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public Dictionary getById(Long id){
        AssertionUtils.notNull(id, "Dictionary id must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Dictionary.class);
            criteria.where(Restrictions.equal("id", id));
            return dictionaryMapper.get(criteria);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<Dictionary> findByGroupId(Long groupId){
        AssertionUtils.notNull(groupId, "Dictionary group id must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Dictionary.class);
            criteria.where(Restrictions.equal("groupId", groupId));
            return dictionaryMapper.find(criteria);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public boolean existsByGroupIdAndCode(Long groupId, String code){
        AssertionUtils.notNull(groupId, "Dictionary group id must not be null");
        AssertionUtils.notBlank(code, "Dictionary code must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Dictionary.class);
            criteria.select(Restrictions.count("id"));
            criteria.where(
                Restrictions.equal("groupId", groupId),
                Restrictions.equal("code", code)
            );

            // result
            Long total = dictionaryMapper.count(criteria);
            return (total != null && total > 0);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}
