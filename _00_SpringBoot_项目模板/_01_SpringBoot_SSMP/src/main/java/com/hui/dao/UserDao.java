package com.hui.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.domain.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
}
