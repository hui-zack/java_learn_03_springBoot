package com.hui.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/* 0-3 UserDao接口继承BaseMapper<User> */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
}
