package com.hui;

import com.hui.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private RedisService redisService;

    @Test
    void redisTest() {
        boolean result = redisService.setKeyValue("hui", "wuYue");
        System.out.println(result);

        String hui = redisService.get("hui");
        System.out.println(hui);
    }

}
