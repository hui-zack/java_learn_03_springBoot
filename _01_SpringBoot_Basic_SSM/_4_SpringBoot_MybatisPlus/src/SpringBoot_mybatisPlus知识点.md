## MybatisPlus特性
    特性:
        1. 无侵入, 只做增强不做改变, 不会对现有工程产生影响
        2. 强大的CRUD操作, 内置通用Mapper, 少量配置即可实现单表CURD操作
        3. 支持Lambda, 编写查询条件无需道心字段写错
        4. 支持主键自动生成
        5. 内置分页插件

## MybatisPlus_SpringBoot环境
[使用mybatisPlus]
    [0-1 导入mybatis-plus依赖](../pom.xml)
    [0-2 实体类中配置对应表](./main/java/com/hui/domain/User.java)
    [0-3 UserDao接口继承BaseMapper<User>](./main/java/com/hui/dao/UserDao.java)
    [0-4 开启mybatisPlus运行日志到控制台](./main/resources/application.yml)
[字段映射与表名映射]
    [0-5-1 表名映射](./main/java/com/hui/domain/User.java)
[0-5-2 字段映射]
    [0-5-2-1 匹配数据库列名](./main/java/com/hui/domain/User.java)
    [0-5-2-2 字段不参与查询](./main/java/com/hui/domain/User.java)
    [0-5-2-3 属性不与任何表字段匹配](./main/java/com/hui/domain/User.java)
    
## id生成策略
[设置id生成策略]
    [0-6-1 单表设置id生成策略](./main/java/com/hui/domain/User.java)
    [0-6-2 配置全部表的默认id生成策略](./main/resources/application.yml)
    
    1. @TableId(value = "id", type = IdType.AUTO); 默认ASSIGN_ID选项
        idType枚举选项:
            AUTO:
                使用数据库的id生成策略
            NONE:
                不设置id生成策略
            INPUT:
                用户输入值作为主键值
            ASSIGN_ID:
                雪花算法id生成策略
            ASSIGN_UUID:
                自动生成uuid作为主键值传入
    2. 雪花算法:
        特点: 64位长度
        雪花算法内容:
            1bit:                       生成标识正数, 无实际意义
            41bit:                      时间戳
            5bit(群组id)+5bit(机器id):   机器码
            12bit:                      存放序列号     
            
## Mybatis单表增删改查


[单表增删改查]
    [1-1 添加](./main/java/com/hui/service/UserService.java)
    [1-2 删除](./main/java/com/hui/service/UserService.java)
    [1-3 修改](./main/java/com/hui/service/UserService.java)
    [1-4-1 查单个](./main/java/com/hui/service/UserService.java)
    [1-4-2 查所有](./main/java/com/hui/service/UserService.java)
    [1-5-1 设置分页拦截器](./main/java/com/hui/config/MybatisPlusConfig.java)
    [1-5-2 分页长须](./main/java/com/hui/service/UserService.java)
    
## 条件查询:
[条件查询]
    [2-1 条件查询](./main/java/com/hui/service/UserService.java)
    [2-2 常用函数](./main/java/com/hui/service/UserService.java)
    
    =       -->     eq(...)
    <       -->     lt(...)
    <=      -->     le(...)
    >       -->     gt(...)
    >=      -->     ge(...)
    
    
## 动态sql:
[动态sql]
    [3-1 动态sql](./main/java/com/hui/service/UserService.java)

## 查询投影
[查询后函数(查询投影)-常用于统计]
    [4-1 查询投影](./main/java/com/hui/service/UserService.java)

## 多记录删除和多记录查询
[多记录删除和多积累查询]
    [5-1-1 多记录查询](./main/java/com/hui/service/UserService.java)
    [5-1-2 多记录删除](./main/java/com/hui/service/UserService.java)

## 逻辑删除
[逻辑删除]
    [6-1 使用@TableLogin()注解逻辑删除字段](./main/java/com/hui/domain/User.java)
        [6-2-1 配置所有表添加逻辑删除](./main/resources/application.yml)
    [6-2 使用逻辑删除](./main/java/com/hui/service/UserService.java)

    如果表中配置了逻辑删除注解:
        之后的所有删除操作将自动使用逻辑删除update数据
        之后所有的查询操作将自动添加条件where deleted = 0;
        
## 乐观锁
[使用乐观锁应对高并发修改]
    [7-1 在mybatisPlus中添加乐观锁拦截器](./main/java/com/hui/config/MybatisPlusConfig.java)
    [7-2 使用@Version注解标记乐观锁字段](./main/java/com/hui/domain/User.java)
    [ -3 使用乐观锁添加数据, 应对高并发场景](./main/java/com/hui/service/UserService.java)

## 代码生成器
[代码生成器](https://www.bilibili.com/video/BV1Fi4y1S7ix?p=118&spm_id_from=pageDriver&vd_source=d2a76462ea1d3d324c39a4a05c5ed548)
    
    一般不用, 除非表特别多