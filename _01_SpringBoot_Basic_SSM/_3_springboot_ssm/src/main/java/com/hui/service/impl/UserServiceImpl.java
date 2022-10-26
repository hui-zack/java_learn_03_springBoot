package com.hui.service.impl;

import com.hui.controller.code.Code;
import com.hui.dao.UserDao;
import com.hui.domain.User;
import com.hui.exception.BusinessException;
import com.hui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(User user) {
        userDao.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        userDao.update(user);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        userDao.delete(id);
        return true;
    }

    @Override
    public User selectById(Integer id) {
        /* 2-5 使用自定义异常 try..catch处理-抛出自定义异常 */
//        try{
//            int i = 1/0;
//        } catch (ArithmeticException e){
//            throw new BusinessException(Code.BUSINESS_ERROR, "操作失误");
//        }

         return userDao.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
