package com.hui.service;



import com.hui.config.IpCountConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/* 1-3 创建service类, 实现功能配置为Bean */
@Service
public class IpCountService {
    private Map<String, Integer> ipCountMap = new HashMap<String, Integer>();

    /**
     * 当前的request对象的注入工作由使用当前的starter的工程自动装配
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 每次调用当前属性, 就记录当前访问的IP, 然后累加访问次数
     */
    public void count(){
        String ip = httpServletRequest.getRemoteAddr();
        System.out.println("---- find the ip " + ip + " ----");
        if (ipCountMap.get(ip) == null){
            ipCountMap.put(ip, 1);
        }else {
            ipCountMap.put(ip, ipCountMap.get(ip) + 1);
        }
    }

    /* 1-3-2 设置定时方法 */
    @Scheduled(cron = "0/2 * * * * ?")      //每两秒执行一次
    public void countIp(){

        System.out.println("        ip访问监控");
        System.out.println("+-----ip-address-----+--num--+");
        for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(String.format("%18s  |%5d", key, value));
        }
        System.out.println("+--------------------+-------+");
    }

    public static void main(String[] args) {
        IpCountConfig ipCountConfig = new IpCountConfig();
        System.out.println(ipCountConfig.toString());
    }
}
