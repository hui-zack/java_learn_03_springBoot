package com.hui.config.cas;

import lombok.Data;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.boot.configuration.EnableCasClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCasClient
@ConditionalOnProperty(prefix = "login", name = "cas", havingValue = "true")
@ConfigurationProperties(prefix = "cas")
@Data
public class CasClientConfig {
    /**
     * CAS server URL E.g. https://example.com/cas or https://cas.example. Required.
     * CAS 服务端 url 不能为空
     */

    private String serverUrlPrefix;

    /**
     * CAS server login URL E.g. https://example.com/cas/login or https://cas.example/login. Required.
     * CAS 服务端登录地址  上面的连接 加上/login 该参数不能为空
     */

    private String serverLoginUrl;

    /**
     * CAS-protected client application host URL E.g. https://myclient.example.com Required.
     * 当前客户端的地址
     */

    private String clientHostUrl;

    @Autowired
    private LoginConfig loginConfig;

    @Autowired
    private Environment environment;

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthenticationFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/api/user/*");
        registration.addUrlPatterns("/api/alarm/*");
        registration.addUrlPatterns("/");
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("casServerLoginUrl", serverUrlPrefix);
        initParameters.put("serverName", clientHostUrl);
        //忽略的url，"|"分隔多个url
        initParameters.put("ignorePattern", loginConfig.getCasIgnoreHostUrl());

        registration.setInitParameters(initParameters);

        registration.setOrder(1);
        return registration;
    }





}
