package com.hui.domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
@Data
public class User {
    @Autowired
    private Integer id;
    private String name2;
    private String city;
    private Integer age;
}
