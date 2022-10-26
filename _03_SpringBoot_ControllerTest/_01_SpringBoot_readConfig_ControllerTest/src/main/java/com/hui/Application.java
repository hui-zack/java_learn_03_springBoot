package com.hui;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        DruidDataSource bean = ctx.getBean(DruidDataSource.class);
        System.out.println(bean);
        String driverClassName = bean.getDriverClassName();
        System.out.println(driverClassName);
    }

}
