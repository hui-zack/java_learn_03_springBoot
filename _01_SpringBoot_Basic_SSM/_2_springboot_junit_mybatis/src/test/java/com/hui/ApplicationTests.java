package com.hui;

import com.hui.domain.User;
import com.hui.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/* 1 在和Application引导类的test同级目录下, 使用SpringBootTest编写测试类 */
@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.save();
    }

    @Test
    void testGeyById(){
        User user = userService.selectById(2);
        System.out.println(user);
    }

}
