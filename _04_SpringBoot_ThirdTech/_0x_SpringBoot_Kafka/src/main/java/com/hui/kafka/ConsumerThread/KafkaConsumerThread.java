package com.hui.kafka.ConsumerThread;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

@Slf4j
public class KafkaConsumerThread {
    @Autowired
    private static KafkaConsumer<String, String> kafkaConsumer;


//    public static Runnable kafkaConsumerThread() {
//        return new Runnable() {
//            @Override
//            public void run() {
//                log.info("start kafkaConsumerThread");
//                KafkaConsumer<String, String> kafkaConsumer = getKafkaConsumer();
//                List<String> topicList = KafkaUtil.getNeedListenTopicList();
//                kafkaConsumer.subscribe(topicList);
//                int length = topicList.size();
//
//                while (true) {                                               // 使用while循环不间断拉取数据
//                    //System.out.println("new length = " + topicList.size());
//                    //如果有设备添加则更新消费者topic
//
//                    if (topicList.size() != length) {
//                        kafkaConsumer.close();
//                        log.info("topicList has be changed, close old kafkaConsumer, create a new kafkaConsumer");
//                        createKafkaConsumer();
//                        kafkaConsumer.subscribe(topicList);
//                        length = topicList.size();
//                    }
////                    String value = consumerRecord.value();
////                    JSONObject dataOfJson = JSONObject.parseObject(value);
////
////                    String uuid1 = dataOfJson.getString("uuid");
//
//                    // 一次拉取一批数据过来; 设定拉取的超时时间
//                    ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(2));
//
//                    for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
//                        String topic = consumerRecord.topic();
//                        String key = consumerRecord.key();
//                        String value = consumerRecord.value();
//                        long offset = consumerRecord.offset();
//
//                        //System.out.println(topicList.toString());
//                        log.info("consumer data from kafka(" + KafkaUtil.getKafkaUrl() + "): topic:" +
//                                topic + ",  offset:" + offset + ",  value:" + value);
//
//                        //System.out.println((JsonUtil.isJSON(value)));
//                        if (JsonUtil.isJSON(value) && value.contains("commandID") && value.contains("messageID")) {
//                            //发送到maps
//                            JSONObject dataOfJson = JSONObject.parseObject(value);
//
//                            String uuid = dataOfJson.getString("uuid");
//                            Integer commandID = dataOfJson.getInteger("commandID");
//                            String messageID = dataOfJson.getString("messageID");
//
//                            //System.out.println("box 响应" + dataOfJson);
//                            String mapKey = MessageService.getMapKey(uuid, messageID);
//                            switch (commandID) {
//                                case 0:
//                                    MessageService.getId0Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 1:
//                                    MessageService.getId1Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 2:
//                                    MessageService.getId2Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 3:
//                                    MessageService.getId3Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 4:
//                                    MessageService.getId4Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 5:
//                                    MessageService.getId5Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 6:
//                                    MessageService.getId6Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 7:
//                                    MessageService.getId7Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 16:
//                                    MessageService.getId16Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 17:
//                                    MessageService.getId17Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 18:
//                                    MessageService.getId18Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 19:
//                                    MessageService.getId19Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                                    break;
//                                case 48:
//                                    //告警map
//                                    MessageService.getId48Map().put(mapKey, value);
//                                    log.info("update messageMap-" + commandID);
//                            }
//                            //System.out.println(consumerQueue);
//                        }
//                    }
//                }
//            }
//        };
//    }
}
