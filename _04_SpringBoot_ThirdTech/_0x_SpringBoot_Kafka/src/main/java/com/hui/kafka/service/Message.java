package com.hui.kafka.service;

import com.hui.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.Future;

@Slf4j
public class Message {
    private static String[] topicList;
    public static void producer( KafkaProducer<String, String> kafkaProducer, String topicName, String value) {
        String key = String.valueOf(DateUtil.getNowTimestamp());
        ProducerRecord<String, String> serverData = new ProducerRecord<>(topicName, key, value);
        Future<RecordMetadata> future = kafkaProducer.send(serverData, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {
                    //发送成功
                    String topic = recordMetadata.topic();      //主题
                    int partition = recordMetadata.partition(); //分区编号
                    long offset = recordMetadata.offset();      //偏移量
                    log.info("send to kafka successful: topic = " + topic +
                            ", partition = " + partition + ", value = " + value);
                } else {
                    log.error("send to kafka failed");
                }
            }
        });
    }


}
