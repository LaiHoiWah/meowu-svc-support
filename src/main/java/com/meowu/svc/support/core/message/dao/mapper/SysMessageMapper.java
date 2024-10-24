package com.meowu.svc.support.core.message.dao.mapper;

import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.svc.support.core.message.entity.SysMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMessageMapper{

    void save(SysMessage message);

    SysMessage get(Criteria criteria);

    List<SysMessage> find(Criteria criteria);
}
