package com.hui.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.dao.UserDao;
import com.hui.domain.User;
import com.hui.domain.actionSql.ActionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /* 1-1 添加 */
    public int insert(User user){
        return userDao.insert(user);
    }
    /* 1-2 删除 */
    public int delete(int id){
        return userDao.deleteById(id);
    }

    /* 1-3 修改 */
    public int update(User user){
        return userDao.updateById(user);
    }

    /* 1-4-1 查单个 */

    public User selectById(int id){
        return userDao.selectById(id);
    }
    /* 1-4-2 查所有 */
    public List<User> selectAll(){
        return userDao.selectList(null);
    }

    /* 1-5-2 分页查询 */
    public List<User> selectByPage(){
        Page<User> page = new Page<>(1, 2);
        Page<User> pageData = userDao.selectPage(page, null);
        System.out.println("当前页码值: " + page.getCurrent());
        System.out.println("每页显示数: " + page.getSize());
        System.out.println("总页数: " + page.getPages());
        System.out.println("总条数: " + page.getTotal());
        System.out.println("数据: " + page.getRecords());

        return page.getRecords();
    }

    /* 2-1 条件查询 */
    public void selectByWhere(){

        /* 方式1 使用字符串书写列名 */
        // QueryWrapper<User> uqw = new QueryWrapper<>();
        // QueryWrapper<User> usersOfLt1000 = uqw.lt("money", 1000);       // money容易写错

        /* 方式2 使用lambda获取列名 */
//        QueryWrapper<User> qw = new QueryWrapper<>();
//        qw.lambda().lt(User::getMoney, 1000);                                  // 使用lambda获取条件查询中的列名

        /* 方式3 使用内置lambda获取 */
        // 1000<money<5000 and关系
        LambdaQueryWrapper<User> lqw1 = new LambdaQueryWrapper<>();
        lqw1.gt(User::getMoney, 1000).lt(User::getMoney, 5000);
        System.out.println("链式and: " + userDao.selectList(lqw1));

        // money>1000或money<5000
        LambdaQueryWrapper<User> lqw2 = new LambdaQueryWrapper<>();
        lqw2.lt(User::getMoney, 1000).or().gt(User::getMoney, 5000);
        System.out.println("链式or: " + userDao.selectList(lqw2));
    }

    /* 2-2 常用函数 */
    public void selectByCommonFunc(){
        /* 等于eq()*/
        String username = "桔梗";
        LambdaQueryWrapper<User> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(true, User::getUsername, username);
        List<User> users = userDao.selectList(lqw1);
        System.out.println(users);

        /* between */
        LambdaQueryWrapper<User> lqw2 = new LambdaQueryWrapper<>();
        lqw2.between(User::getMoney, 500, 2999);
        List<User> users2 = userDao.selectList(lqw2);
        System.out.println(users2);

        /* like */
        LambdaQueryWrapper<User> lqw3 = new LambdaQueryWrapper<>();
        lqw3.likeRight(User::getUsername, "桔");
        List<User> users3 = userDao.selectList(lqw3);
        System.out.println(users3);
    }

    /* 3-1 动态sql */
    public List<User> selectPeople(ActionUser ActionUser){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(null != ActionUser.getUsername(), User::getUsername, ActionUser.getUsername());
        lqw.eq(null != ActionUser.getPassword(), User::getPassword, ActionUser.getPassword());
        lqw.eq(null != ActionUser.getGender(), User::getAddr, ActionUser.getGender());
        lqw.like(null != ActionUser.getAddr(), User::getAddr, ActionUser.getAddr());
        lqw.gt(null != ActionUser.getMinMoney(), User::getMoney, ActionUser.getMinMoney());
        lqw.lt(null != ActionUser.getMinMoney(), User::getMoney, ActionUser.getMaxMoney());

        return userDao.selectList(lqw);
    }

    /* 4-1 查询投影(查询后函数) */
    public List<Map<String, Object>> selectAfterFunc(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.select("count(*) as count, gender");
        qw.groupBy("gender");

        return userDao.selectMaps(qw);
    }

    /* 5-1 多积累删除和多积累查询 */
    public void deleteAndSelectByList(){
        /* 5-1-1 多记录查询 */
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(5);
        idList.add(6);
        idList.add(7);

        List<User> users = userDao.selectBatchIds(idList);
        System.out.println(users);

        /* 5-1-2 多记录删除 */
        ArrayList<Integer> idList2 = new ArrayList<>();
        idList2.add(1);
        idList2.add(20);
        idList2.add(30);

        int result = userDao.deleteBatchIds(idList2);
        System.out.println("delete idList = " + result);
    }
    /* 6-2 使用逻辑删除 */
    public void logicDelete(){
        int result = userDao.deleteById(2);
        System.out.println("[logic delete] result = " + result);
    }

    /* 7-3 使用乐观锁添加数据, 应对高并发场景 */
    public void optimisticLocker(){
        User user = userDao.selectById(9);
        user.setId(9);
        user.setGender("男");
        user.setUsername("杀生丸");
        user.setAddr("西国");
        int result = userDao.updateById(user);
        System.out.println("[optimisticLocker] result = " + result);
    }

}
