package com.hui.kafka.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
public class MyProducerConfig {
    private String acks;
    private String keySerializer;
    private String valueSerializer;
    private String bootstrapServers;
}
