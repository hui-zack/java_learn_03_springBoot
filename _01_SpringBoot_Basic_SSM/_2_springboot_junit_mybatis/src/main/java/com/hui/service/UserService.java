package com.hui.service;

import com.hui.domain.User;

public interface UserService {
    public void save();
    public User selectById(int id);
}
