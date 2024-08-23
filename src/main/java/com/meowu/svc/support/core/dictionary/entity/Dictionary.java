package com.meowu.svc.support.core.dictionary.entity;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Delete;
import com.meowu.starter.commons.domain.Identity;
import com.meowu.starter.commons.domain.Update;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Dictionary implements Identity<Long>, Create, Update, Delete{

    private Long id;
    private String group;
    private String code;
    private String content;
    private Boolean delete;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
