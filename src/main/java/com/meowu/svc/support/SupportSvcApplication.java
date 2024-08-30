package com.meowu.svc.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SupportSvcApplication{

    private final static Logger LOG = LoggerFactory.getLogger(SupportSvcApplication.class);

    public static void main(String[] args){
        SpringApplication.run(SupportSvcApplication.class, args);

        LOG.info("Service has successfully started.");
    }
}
