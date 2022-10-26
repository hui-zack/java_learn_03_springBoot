package com.hui.kafka.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka.admin")

public class MyAdminConfig {
    private String bootstrapServers;
    private Integer timeout;
}
