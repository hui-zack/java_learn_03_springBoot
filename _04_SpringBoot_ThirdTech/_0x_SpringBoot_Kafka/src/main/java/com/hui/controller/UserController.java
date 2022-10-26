package com.hui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
////    @Autowired
////    private MessageService kafkaMessageService;
////
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//    @GetMapping
//
//    public String sendKafkaMessage(){
//        kafkaTemplate.send("123", "fdas");
//        return "123";
//   }

}
