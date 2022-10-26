package com.hui.kafka.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka.consumer")
public class MyConsumerConfig {
    private String bootstrapServers;
    private String groupId;
    private String autoCommitInterval;
    private String keyDeserializer;
    private String valueDeserializer;
}
