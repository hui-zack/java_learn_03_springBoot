package com.hui.config.cas;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "login")
@Data
public class LoginConfig {
    private Boolean cas;
    private String casIgnoreHostUrl;
    private String casWebHomePageUrl;

    @Value("${cas.server-login-url}")
    private String casServerLoginUrl;
    @Value("${cas.server-url-prefix}")
    private String casServerUrlPrefix;
    @Value("${cas.client-host-url}")
    private String casClientHostUrl;
}
