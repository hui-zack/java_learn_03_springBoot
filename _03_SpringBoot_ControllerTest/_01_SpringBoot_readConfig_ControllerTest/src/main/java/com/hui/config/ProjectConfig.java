package com.hui.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.hui.domain.config.DruidConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Autowired
    private DruidConfig druidConfig;
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(druidConfig.getDriverClassName());

        return ds;
    }
}
