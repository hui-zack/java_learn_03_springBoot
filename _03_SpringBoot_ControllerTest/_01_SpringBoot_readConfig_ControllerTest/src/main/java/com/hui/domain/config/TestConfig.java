package com.hui.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/* 1-3-2 根据配置的对象编写配置类-名称与成员变量一一对应 */
@Component
@ConfigurationProperties(prefix = "test.config")            // 指定要注入的配置对象
public class TestConfig {
    private String name;
    private Integer age;
    private String[] classArray;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getClassArray() {
        return classArray;
    }

    public void setClassArray(String[] classArray) {
        this.classArray = classArray;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classArray=" + Arrays.toString(classArray) +
                '}';
    }
}

