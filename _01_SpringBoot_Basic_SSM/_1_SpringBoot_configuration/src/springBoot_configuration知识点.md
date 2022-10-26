## SpringBoot课程学习目标
    基础篇: 
        能够创建SpringBoot工程
        能够使用SpringBoot完成基础的SSM整合
    适用篇:
        运维使实用篇:
            能够掌握SpringBoot程序多环境开发
            能够基于Linux系统发布SpringBoot工程
            能够解决线上灵活配置SpringBoot工程的需求
        开发使用篇:
            能够基于SpringBoot整合任意第三方技术
    原理篇:
        掌握SpringBoot内部工作流程
        理解SpringBoot整合第三方技术的原理
        实现自定义开发整合第三方技术的组件
        
## SpringBoot概念
    SpringBoot是由Pivotal团队提供的全新框架, 其设计目的是简化Spring应用的初始搭建以及开发过程

## idea构建SpringBoot项目
    创建项目时使用
        Spring initinlizr创建, 选择Web.Spring-web项目
        创建项目时, 可以使用阿里云创建项目
            https://start.aliyun.com
## 复制已有SpringBoot结构
    1. 复制对应的工程文件夹
    2. 删除idea相关配置文件, 仅保留src目录和pom.xml文件
    3. 修改pom.xml文件中的artifactId与新工程模块名相同
    3. 删除name和describe标签
    5. 将该工程保留供后期使用
    
## SpringBoot的三种配置文件
    1. SpringBoot支持的三种配置文件
        application.properties
        application.yml
        application.yaml
        
        注意: 创建项目时, 自带application.properties文件, 两外两个需要自己创建
    2. idea添加SpringBoot配置文件提示
.           [为自定义配置文件增加代码提示](add_configFIleCodePrompt.jpg)

    3. yaml配置文件:
        扩展名:
            yml
            yaml
        优点:
            容易阅读:
            容易与脚本语言交互
            以数据为核心, 重数据轻格式
            
## SpringBoot读取YML文件
[读取YML配置中的单个信息]
    [1-1-1 读取单个String](../../java/com/hui/controller/UserController.java)
    [1-1-2 读取单个Array](../../java/com/hui/controller/UserController.java)
[一次读取所有配置文件]
    [1-2 读取所有配置文件信息_Environment](../../java/com/hui/controller/UserController.java)
    
[封装配置类读取指定配置对象]
    [1-3-1 SpringBoot_configuration相关注解依赖](../../../../pom.xml)
    [1-3-2 根据配置的对象编写配置类-名称与成员变量一一对应](../../java/com/hui/domain/TestConfig.java)
    [1-3-3 注入自定义配置对象](../../java/com/hui/controller/UserController.java)

## SpringBoot配置多环境开发
[SpringBoot配置多环境开发]
    [2 多环境开发](../application.yml)
        [2-1 开发环境](../application.yml)
        [2-2 测试环境](../application.yml)
        [2-2 生产环境](../application.yml)
    [3 maven配置多环境开发](../../../../pom.xml) 
        [3-1 maven配置多环境开发](../../../../pom.xml) 

    1. 启动SpringBoot_jar包时指定启动环境
        java -jar springboot_fast_learn-0.0.1-SNAPSHOT.jar --spring.profiles.active=test    
        
## SpringBoot_4级配置文件
    1. 4级配置文件
        以jar包所在位置为当前目录:
            ./config/application.yml                       -> 最优先
            application.yml                                -> 次优先
            代码内部: resources/config/application.xml      -> 第三
            代码内部: resources/application.xml             -> 最后