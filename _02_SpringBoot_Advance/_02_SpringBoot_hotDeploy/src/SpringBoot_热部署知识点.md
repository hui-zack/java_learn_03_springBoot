## SpringBoot使用热部署
[热部署]
    [1-1 pom导入热部署依赖](../../../../pom.xml)
    [1-2 手动激活热部署](hotDeploy1.jpg)
    [1-3 自动热部署](https://www.bilibili.com/video/BV15b4y1a7yG?p=71&spm_id_from=pageDriver&vd_source=d2a76462ea1d3d324c39a4a05c5ed548)


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