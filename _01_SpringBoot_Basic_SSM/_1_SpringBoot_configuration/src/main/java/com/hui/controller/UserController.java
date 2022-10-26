package com.hui.controller;


import com.hui.domain.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
//    /* 1-1-1 YML_读取单个String */
//    @Value("${server.port}")
//    private String serverPort;
//
//    /* 1-1-2 读取单个_Array */
//    @Value("${test.config.classArray[2]}")
//    private String theArray;

    /* 1-2 读取所有配置文件信息_Environment */
    @Autowired
    private Environment environment;

    @Autowired
    /* 1-3-3 注入自定义配置对象 */
    private TestConfig testConfig;

    @GetMapping("")
    public String getVersion(){
//        System.out.println("--------------------- readYML-one ----------------------");
//        System.out.println("server.port = " + serverPort);
//        System.out.println("classArray[2] = " + theArray);

        System.out.println("--------------------- readYML-all ----------------------");
        System.out.println(environment.toString());

        System.out.println(environment.getProperty("server.port"));
        System.out.println(environment.getProperty("test.config.name"));
        System.out.println(environment.getProperty("test.config.age"));
        System.out.println(environment.getProperty("test.config.classArray[0]"));

        System.out.println(testConfig.toString());
        return "hello SpringBoot";
    }
}
