package com.meowu.svc.support.core.snowflake.entity;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Identity;
import com.meowu.starter.commons.domain.Update;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Snowflake implements Identity<Long>, Create, Update{

    private Long id;
    private Integer centerId;
    private Integer workerId;
    private Long lastTimestamp;
    private String application;
    private String ip;
    private String port;
    private Date createTime;
    private Date updateTime;
}
