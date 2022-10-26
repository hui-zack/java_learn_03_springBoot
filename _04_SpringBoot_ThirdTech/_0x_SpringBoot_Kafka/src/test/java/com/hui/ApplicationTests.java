package com.hui;

import com.hui.kafka.domain.MyAdminConfig;
import com.hui.kafka.domain.MyConsumerConfig;
import com.hui.kafka.domain.MyProducerConfig;
import com.hui.kafka.service.Message;
import com.hui.kafka.utils.KafkaUtil;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private MyConsumerConfig consumerConfig;
    @Autowired
    private MyProducerConfig producerConfig;
    @Autowired
    private MyAdminConfig adminConfig;

    @Test
    void testConfig(){
        System.out.println(consumerConfig);

        System.out.println(producerConfig);
        System.out.println(adminConfig);
    }

    @Test
    void testKafka(@Autowired AdminClient adminClient){
        Boolean aBoolean = KafkaUtil.KafkaStatus(adminClient, adminConfig.getTimeout());

    }

    @Test
    void testSend(@Autowired KafkaProducer<String, String> kafkaProducer){
        Message.producer(kafkaProducer, "134", "fdsafdsa");
    }

}
