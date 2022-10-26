package com.hui.kafka.config;

import com.hui.kafka.domain.MyAdminConfig;
import com.hui.kafka.domain.MyConsumerConfig;
import com.hui.kafka.domain.MyProducerConfig;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;




@Slf4j
@Configuration
@Import({MyAdminConfig.class, MyProducerConfig.class, MyConsumerConfig.class})
public class KafkaConfig implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
