package com.hui;

import com.hui.domain.User;
import com.hui.service.MongodbService;
import com.mongodb.client.result.DeleteResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private MongodbService mongodbService;

    @Test
    void testMongodbSave() {
        User user = new User();
        user.setId(1);
        user.setName2("五月");
        user.setAge(17);
        user.setCity("京都");
        mongodbService.save(user);
    }

    @Test
    void testMongodbDelete() {
        User user = new User();
        user.setName2("五月");


        Long deleteNum = mongodbService.delete(user);
        System.out.println(deleteNum);

    }

    @Test
    void testMongodbUpdateOne() throws Exception {
        User user = new User();
        user.setName2("五月");
        user.setCity("中国");
        Long updateNum = mongodbService.updateOne(user);
        System.out.println(updateNum);

    }

}
