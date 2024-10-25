package com.meowu.svc.support.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(value = DruidProperties.class)
@ConditionalOnProperty(name = "spring.druid.database", havingValue = "h2")
public class H2DatasourceConfig{

    @Bean
    public DataSource datasource(DruidProperties properties){
        DruidDataSource datasource = new DruidDataSource();

        // datasource
        datasource.setUrl(properties.getUrl());
        datasource.setDriverClassName(properties.getDriverClassName());
        datasource.setUsername(properties.getUsername());
        datasource.setPassword(properties.getPassword());

        // pool setting
        datasource.setInitialSize(properties.getInitialSize());
        datasource.setMaxActive(properties.getMaxActive());
        datasource.setMinIdle(properties.getMinIdle());
        datasource.setMaxWait(properties.getMaxWait());

        return datasource;
    }
}
