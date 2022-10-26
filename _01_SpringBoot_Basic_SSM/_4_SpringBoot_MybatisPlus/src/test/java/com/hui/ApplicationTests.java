package com.hui;

import com.hui.domain.User;
import com.hui.domain.actionSql.ActionUser;
import com.hui.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserService userService;

    /* 增 */
    @Test
    void testSave(){
        User user = new User();
        user.setUsername("犬夜叉");
        user.setAddr("日本");
        user.setGender("男");
        user.setMoney((long) 100000);
        user.setPassword("123456");

        int saveFlag = userService.insert(user);
        System.out.println("saveFlag return = "  + saveFlag);
    }

    @Test
    void testDelete(){
        int deleteFlag = userService.delete(8);
        System.out.println("deleteFlag return = " + deleteFlag);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(7);
        user.setUsername("戈薇");
        user.setGender("女");
        int updateFlag = userService.update(user);
        System.out.println("updateFlag return = " + updateFlag);
    }

    @Test
    void testSelectOne() {
        User user = userService.selectById(7);
        System.out.println(user.toString());
    }

    @Test
    void testGetAll() {
        List<User> userList = userService.selectAll();
        System.out.println(userList);
    }

    @Test
    void testSelectByPage(){
        List<User> users = userService.selectByPage();
        System.out.println(users);
    }

    @Test
    void testSelectByWhere(){
        System.out.println("条件查询: ");
        userService.selectByWhere();
    }

    @Test
    void testSelectPeople(){
        System.out.println("动态SQL");
        ActionUser actionUser = new ActionUser();
        actionUser.setMinMoney(2000L);
        actionUser.setMaxMoney(200000L);
        actionUser.setAddr("日本");
        List<User> users = userService.selectPeople(actionUser);
        System.out.println(users);
    }

    @Test
    void testCommonFunc(){
        System.out.println("常用函数");
        userService.selectByCommonFunc();
    }

    @Test
    void testSelectAfterFunc(){
        System.out.println("查询投影");
        List<Map<String, Object>> countList = userService.selectAfterFunc();
        System.out.println(countList);
    }

    @Test
    void testDeleteAndSelectByList(){
        System.out.println("多记录删除和所记录查询");
        userService.deleteAndSelectByList();
    }

    @Test
    void testLogicDelete(){
        System.out.println("逻辑删除:");
        userService.logicDelete();
    }

    @Test
    void testOptimisticLocker(){
        System.out.println("乐观锁:");
        userService.optimisticLocker();
    }

}
