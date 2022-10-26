## idea构建SpringBoot项目
    创建项目时使用
        Spring initinlizr创建, 选择Web.Spring-web项目
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
            
## SpringBoot读取YAM文件
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
        
## SpringBoot4配置4级配置文件
    1. 4级配置文件
        以jar包所在位置为当前目录:
            ./config/application.yml                       -> 最优先
            application.yml                                -> 次优先
            代码内部: resources/config/application.xml      -> 第三
            代码内部: resources/application.xml             -> 最后