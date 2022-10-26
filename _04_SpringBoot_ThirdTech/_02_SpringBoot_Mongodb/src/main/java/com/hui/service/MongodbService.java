package com.hui.service;

import com.hui.domain.User;
import com.hui.utils.ClassUtil;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import sun.reflect.misc.FieldUtil;

import java.lang.reflect.Field;

@Service
public class MongodbService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 存储到mongodb的hui数据库, 一个domain类对应一个库集合, 如果库中不存在该集合则会新建
     *      如: 传入一个user对象, hui库不存在该集合, mongodb创建一个user集合用于存储数据
     * @param user user的封装对象-domain
     */
    public void save(User user){
        mongoTemplate.save(user);
    }

    public Long delete(User user){
        Query query = Query.query(Criteria.where(ClassUtil.getEleName(User::getName2)).is(user.getName2()));
        DeleteResult remove = mongoTemplate.remove(query, user.getClass());

        return remove.getDeletedCount();
    }

    public Long updateOne(User user) throws Exception {
        if(true) throw new Exception("未编写代码");
        return 1L;
    }
}
