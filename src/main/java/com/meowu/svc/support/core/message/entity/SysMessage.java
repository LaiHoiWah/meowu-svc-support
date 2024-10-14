package com.meowu.svc.support.core.message.entity;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Delete;
import com.meowu.starter.commons.domain.Identity;
import com.meowu.starter.commons.domain.Update;
import com.meowu.starter.commons.security.constants.RecordStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysMessage implements Identity<Long>, Create, Update, Delete{

    private Long id;
    private String code;
    private String content;
    private RecordStatus status;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
