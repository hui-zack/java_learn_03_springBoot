package com.hui.service;

import com.hui.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional                      /* old_1-3 业务层接口添加添加事务注解 */
public interface UserService {
    public boolean add(User user);

    public boolean update(User user);

    public boolean delete(Integer id);

    public User selectById(Integer id);

    @Transactional(timeout = 5)
    public List<User> selectAll();
}
