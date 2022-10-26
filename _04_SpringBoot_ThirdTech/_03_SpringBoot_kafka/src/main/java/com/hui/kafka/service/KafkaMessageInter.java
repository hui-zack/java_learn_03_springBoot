package com.hui.kafka.service;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;


public interface KafkaMessageInter {
    /**
     *
     * @param kafkaProducer kafka生产者对象
     * @param topicName topic主题
     * @param value 发送值
     */
    void producer(@Autowired KafkaProducer<String, String> kafkaProducer, String topicName, String value);

    /**
     * 消费者线程
     * @return Runnable线程, 可在线程池中运行
     */
    Runnable consumer();
}
