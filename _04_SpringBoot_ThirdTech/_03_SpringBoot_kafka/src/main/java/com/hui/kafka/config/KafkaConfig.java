package com.hui.kafka.config;

import com.hui.kafka.domain.MyAdminConfig;
import com.hui.kafka.domain.MyConsumerConfig;
import com.hui.kafka.domain.MyProducerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Properties;

@Slf4j
@Configuration
@Import({MyAdminConfig.class, MyProducerConfig.class, MyConsumerConfig.class})
public class KafkaConfig {
    /**
     * kafka生产者
     * @return KafkaProducer<String, String> kafka生产者对象
     */
    @Bean
    public KafkaProducer<String, String> getKafkaProducer(@Autowired MyProducerConfig producerConfig){
        Properties pProp = new Properties();
        pProp.put("bootstrap.servers", producerConfig.getBootstrapServers());
        pProp.put("acks", producerConfig.getAcks());
        pProp.put("key.serializer", producerConfig.getKeySerializer());
        pProp.put("value.serializer", producerConfig.getValueSerializer());
        log.info("try create kafkaProducer");
        return new KafkaProducer<>(pProp);
    }

    @Bean
    public KafkaConsumer<String, String> getKafkaConsumer(@Autowired MyConsumerConfig consumerConfig){
        Properties cProps = new Properties();
        cProps.put("bootstrap.servers", consumerConfig.getBootstrapServers());
        // 消费者组(将若干个消费者组织到一起, 共同消费kafka主题中的数据);如果消费者组名一致, 说明这些消费者在一个组中
        cProps.put("group.id", consumerConfig.getGroupId());
        //自动提交的时间间隔
        cProps.put("auto.commit.interval.ms", consumerConfig.getAutoCommitInterval());
        cProps.put("key.deserializer", consumerConfig.getKeyDeserializer());
        cProps.put("value.deserializer", consumerConfig.getValueDeserializer());
        log.info("try create kafkaConsumer");
        return new KafkaConsumer<>(cProps);
    }

    @Bean
    public AdminClient getAdminClient(@Autowired MyAdminConfig adminConfig){
        Properties aProp = new Properties();
        aProp.put("bootstrap.servers", adminConfig.getBootstrapServers());
        log.info("try create kafkaAdminClient");
        return AdminClient.create(aProp);
    }

}
