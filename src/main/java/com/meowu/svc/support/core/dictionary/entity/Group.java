package com.meowu.svc.support.core.dictionary.entity;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Delete;
import com.meowu.starter.commons.domain.Identity;
import com.meowu.starter.commons.domain.Update;
import com.meowu.starter.commons.security.constants.RecordStatus;
import com.meowu.starter.mybatis.security.stereotype.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName(value = "st_group")
public class Group implements Identity<Long>, Create, Update, Delete{

    private Long id;
    private String code;
    private String display;
    private String description;
    private RecordStatus status;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
