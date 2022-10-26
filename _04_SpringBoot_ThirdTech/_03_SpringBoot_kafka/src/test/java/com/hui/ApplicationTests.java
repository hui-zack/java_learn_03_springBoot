package com.hui;

import com.hui.kafka.domain.MyAdminConfig;
import com.hui.kafka.domain.MyConsumerConfig;
import com.hui.kafka.domain.MyProducerConfig;
import com.hui.kafka.utils.KafkaUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executor;

@Slf4j
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
    void testConsumer(@Autowired Executor executor){

    }

}
