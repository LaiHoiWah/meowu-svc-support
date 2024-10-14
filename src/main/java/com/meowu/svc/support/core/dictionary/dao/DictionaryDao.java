package com.meowu.svc.support.core.dictionary.dao;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.criteria.expression.Order;
import com.meowu.starter.mybatis.mysql.restrictions.Restrictions;
import com.meowu.starter.mybatis.security.exception.DataAccessException;
import com.meowu.svc.support.core.dictionary.dao.mapper.DictionaryMapper;
import com.meowu.svc.support.core.dictionary.entity.Dictionary;
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
        AssertionUtils.notBlank(dictionary.getGroupCode(), "Dictionary group code must not be null");
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

    public List<Dictionary> findByGroupCode(String groupCode){
        AssertionUtils.notBlank(groupCode, "Dictionary group code must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Dictionary.class);
            criteria.where(Restrictions.equal("groupCode", groupCode));
            criteria.sort(Restrictions.asc("rank"));
            return dictionaryMapper.find(criteria);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<Dictionary> findByGroupCodes(List<String> groupCodes){
        AssertionUtils.notEmpty(groupCodes, "Dictionary group code list must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Dictionary.class);
            criteria.where(Restrictions.in("groupCode", groupCodes));
            criteria.sort(Restrictions.asc("rank"));
            return dictionaryMapper.find(criteria);
        }catch(Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public boolean existsByGroupCodeAndCode(String groupCode, String code){
        AssertionUtils.notBlank(groupCode, "Dictionary group code must not be null");
        AssertionUtils.notBlank(code, "Dictionary code must not be null");

        try{
            // condition
            Criteria criteria = new Criteria();
            criteria.from(Dictionary.class);
            criteria.select(Restrictions.count("id"));
            criteria.where(
                Restrictions.equal("groupCode", groupCode),
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
