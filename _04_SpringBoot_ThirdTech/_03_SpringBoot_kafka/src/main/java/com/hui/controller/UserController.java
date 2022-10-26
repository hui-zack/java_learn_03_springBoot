package com.hui.controller;

import com.hui.service.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private Message message;
    @Qualifier("SystemCachedThead")
    @Autowired
    private Executor executor;
//    @Autowired
//    private ExecutorService executorService;

    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    @GetMapping
    public String sendKafkaMessage(){
        message.producer(kafkaProducer,"123", "fdas");
        executor.execute(mytest());
        return "123";
   }

   public Runnable mytest(){

        return new Runnable() {
            @Override
            public void run() {
                log.info("线程测试");
            }
        };
   }

}
