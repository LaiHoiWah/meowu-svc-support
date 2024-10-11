package com.meowu.svc.support.core.application.entity;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Delete;
import com.meowu.starter.commons.domain.Identity;
import com.meowu.starter.commons.domain.Update;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Application implements Identity<Long>, Create, Update, Delete{

    private Long id;
    private String name;
    private String type;
    private String ip;
    private Integer port;
    private String status;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Date lastOnlineTime;
}
