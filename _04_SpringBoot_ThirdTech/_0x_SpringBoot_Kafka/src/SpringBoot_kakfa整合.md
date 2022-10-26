## SpringBoot整合redis
[整合kafka步骤]
    [1-1 在pom中添加kafka依赖](../../../../pom.xml)
    [1-2 配置文件中指定redis-server地址](../application.yml)
    [1-3 编写RedisService](../../java/com/hui/service/redis/RedisService.java)
    
    SpringBoot整合redis客户端技术:
        lettuce:    默认              线程安装
        jedis:      以前常用的技术     高并发下线程不安全
























## SpringBoot的SSMP整合
[1. pom.xml]
    [配置起步依赖](../../../../pom.xml)
[2. application.yml]
    [配置端口, 数据源等](../application.yml)
[3. dao]  
    [设置@Mapper注解, 继承baseMapper<T>](../../java/com/hui/dao/UserDao.java)
    [MybatisPlus-分页拦截器和乐观锁拦截器](../../java/com/hui/config/MybatisPlusConfig.java)
[4. service]
    [使用MybatisPlus提供的方法快速开发](../../java/com/hui/service/UserService.java)
[5. ProjectExceptionHandler]
    [自定义业务异常类](../../java/com/hui/exception/BusinessException.java)
    [自定义系统异常类](../../java/com/hui/exception/SystemException.java)
    [项目异常处理器](../../java/com/hui/exception/ProjectExceptionHandler.java)
[6. controller]
    [REST风格-controller](../../java/com/hui/controller/UserController.java) 
    [业务Code类](../../java/com/hui/controller/code/Code.java) 
    [统一响应类](../../java/com/hui/controller/dataResponse/Result.java)
[7. 设置日志]
    [pom添加lombok依赖](../../../../pom.xml)
    [在controller中使用](../../java/com/hui/controller/UserController.java)
    [配置文件中设定日志输出级别](../application.yml)
    [配置文件中设定日志文件](../application.yml)