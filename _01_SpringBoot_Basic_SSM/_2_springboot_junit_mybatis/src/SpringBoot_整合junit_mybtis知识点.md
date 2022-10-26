## SpringBoot整合junit
[SpringBoot使用junit]
    [1 在和Application引导类的test同级目录下, 使用SpringBootTest编写测试类](../../../test/java/com/hui/ApplicationTests.java)
    
    注意: 
        如果测试类在SpringBoot启动类(Application.java)的包或子包里(包含测试包): 
            使用@SpringBoot注解时无需指定classes=Application.class属性
        如果测试类不在SpringBoot启动类(Application.java)的包或子包里(包含测试包): 
            使用@SpringBoot  注解时需要指定classes=Application.class属性
            
            
            
## SpringBoot整合mybatis知识点
[SpringBoot整合mybatis]
    [2-1 创建项目时添加](./SpringBoot_+_mybitis_mysql_mvc.jpg)
        [2-1-1 在pom中添加druid数据源](../../../../pom.xml)
    [2-2 在配置文件中设置mysql连接参数](../../resources/application.yml)
    [2-3 将dao包下的接口类使用mapper注解](../../java/com/hui/dao/UserDao.java)
    [2-4 在UserService中查询](../../java/com/hui/service/impl/UserServiceImpl.java)

    
