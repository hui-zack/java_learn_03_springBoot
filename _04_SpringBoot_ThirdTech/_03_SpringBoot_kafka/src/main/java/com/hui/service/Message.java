package com.hui.service;

import com.hui.kafka.service.KafkaMessageInter;
import com.hui.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
@EnableAsync
public class Message implements KafkaMessageInter {

    @Override
    public void producer(KafkaProducer<String, String> kafkaProducer, String topicName, String value) {
        ProducerRecord<String, String> serverData = new ProducerRecord<>(topicName, value);

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

    @Async
    @Override
    public Runnable consumer() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread");
            }
        };
    }

}
