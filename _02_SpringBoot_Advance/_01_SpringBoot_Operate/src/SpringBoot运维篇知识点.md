## SpringBoot四级配置文件
    1. 配置文件优先级分类
        1级: file: config/application.yml
        2级: application.yml
        3级: classpath: reources/config/application.yml
        4级: classpath: application.yml
    2. 作用: 
        1级和2级六座系统打包后设置通用属性, 1级常用于运维经理进行线上项目部署方案调控
        3级和4级用于熊开发阶段设置通用属性, 3级常用于项目经理进行整体下古墓属性调控
        
## SpringBoot多环境配置
[多环境配置]
    [1-1 在配置文件中配置多环境](../application.yml)
    
    终端命令中指定运行环境:  
        java -jar springboot_operate-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
        
## 日志操作
[设置日志级别]
    [2-1 pom添加lombok依赖](../../../../pom.xml)
    [2-2 在controller中使用](../../java/com/hui/controller/UserController.java)
    [2-3 配置文件中日志输出级别](../application.yml)
    
    日志的作用:
        1. 编程期调试代码
        2. 运营期记录信息
            记录日常运营重要信息(峰值流量, 平均响应时长)
            记录应用报错信息(错误堆栈)
            记录运维过程数据(扩容, 宕机, 报警, ...)