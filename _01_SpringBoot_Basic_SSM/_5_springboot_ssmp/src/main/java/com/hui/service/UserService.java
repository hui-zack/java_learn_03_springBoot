package com.hui.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hui.dao.UserDao;
import com.hui.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 查询所有
     * @return ArrayList<User>
     */
    public List<User> selectAll(){
        return userDao.selectList(null);
    }

    /**
     * 根据id查询
     * @param id User表的id值-主键
     * @return User对象
     */
    public User selectById(Integer id){
        return userDao.selectById(id);
    }

    /**
     * 添加
     * @param user User对象
     * @return Boolean 成功返回true, 失败返回false
     */
    public Boolean insert(User user){
        return userDao.insert(user) != 0;
    }

    /**
     * 根据id删除
     * @return Boolean 成功返回true, 失败返回false
     */
    public boolean deleteById(Integer id){
        return userDao.deleteById(id) != 0;
    }

    /**
     * 根据id修改
     * @param user User对象
     * @return Boolean - 成功返回true, 失败返回false
     */
    public Boolean updateById(User user){
        return userDao.updateById(user) != 0;
    }


}
