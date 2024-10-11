package com.meowu.svc.support.core.dictionary.entity;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Delete;
import com.meowu.starter.commons.domain.Identity;
import com.meowu.starter.commons.domain.Update;
import com.meowu.starter.mybatis.security.stereotype.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName(value = "st_dictionary")
public class Dictionary implements Identity<Long>, Create, Update, Delete{

    private Long id;
    private Long groupId;
    private String code;
    private String display;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
