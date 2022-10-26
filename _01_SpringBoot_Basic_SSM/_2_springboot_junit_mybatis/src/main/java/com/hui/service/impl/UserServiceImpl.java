package com.hui.service.impl;

import com.hui.dao.UserDao;
import com.hui.domain.User;
import com.hui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service                                                        /* 2-4 在UserService中查询 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void save() {
        System.out.println("UserService.save() is running");
    }

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }
}
