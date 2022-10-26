package com.hui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean setKeyValue(String key, String value){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value);
        return true;
    }

    public String get(String key){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        return ops.get(key);
    }

}
