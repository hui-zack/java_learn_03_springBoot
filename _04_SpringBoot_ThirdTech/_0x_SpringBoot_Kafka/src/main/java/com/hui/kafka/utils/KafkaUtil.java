package com.hui.kafka.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;

import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;

import java.util.concurrent.ExecutionException;

@Slf4j
public class KafkaUtil {

    /**
     * 判断kafka是否在线
     * @param adminClient kafka管理对象, 已在KafkaConfig中配置为bean
     * @param timeoutMs 超时时间, 单位为ms
     * @return
     *  正常连接返回true
     *  超时返回false, 并打印error日志
     *  异常返回false不打印日志
     */
    public static Boolean KafkaStatus(AdminClient adminClient, Integer timeoutMs){
        System.out.println("timeoutMs = " + timeoutMs);
        try {
            ListTopicsResult listTopicsResult = adminClient.listTopics(new ListTopicsOptions().timeoutMs(timeoutMs));
            listTopicsResult.names().get();
            return true;
        } catch (InterruptedException | ExecutionException e) {
            if (e.getMessage().contains("TimeoutException")){
                log.error("kafka connect timeout = " + timeoutMs + "ms");
                return false;
            }

            e.printStackTrace();
            return false;
        }
    }
}
