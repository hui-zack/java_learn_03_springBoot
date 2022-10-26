package com.hui.dao;


import com.hui.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper                    /* 2-3 将dao包下的接口类使用mapper注解 */
public interface UserDao {
    @Insert("insert into tb_user (username, password, gender, addr, money) values( #{username}, #{password}, #{gender}, #{addr}, #{money})")
    public void add(User user);

    @Update("update tb_user set username=#{username}, password=#{password}, gender=#{gender}, addr=#{addr}, money=#{money} where id = #{id}")
    public void update(User user);

    @Delete("delete from tb_user where id = #{id}")
    public void delete(Integer id);

    @Select("select * from tb_user where id = #{id}")
    public User selectById(Integer id);

    @Select("select * from tb_user")
    public List<User> selectAll();
}
