package com.meowu.svc.support.config.datasource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.druid")
@Getter
@Setter
public class DruidProperties{

    // datasource
    private String url;
    private String driverClassName;
    private String username;
    private String password;

    // pool setting
    private Integer initialSize = 1;
    private Integer maxActive = 10;
    private Integer minIdle = 1;
    private Integer maxWait = 6000;
}
