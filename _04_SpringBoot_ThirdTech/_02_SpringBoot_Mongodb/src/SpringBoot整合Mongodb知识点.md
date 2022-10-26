## Mongodb
    Mongodb:
        开源, 高性能, 无模式的文档型数据库, NoSQL数据库产品中的一种, 是最像关系型数据库的非关系型数据库
    特点:
        永久性存储和临时存储相结合, 适合存储修改修改频率极高的数据
    使用场景:
        需要临时存储且修改频率高的项目
        需要永久性存储且短时间内修改屏幕高的项目 
    默认启动断开
## Mongodb环境搭建
    1. 下载地址
-->     [下载地址](https://www.mongodb.com/try/download)

    2. 安装
-->     [window版安装包地址](../../../../../_00_资源/_02_mongodb/mongodb-windows-x86_64-5.0.5.zip)

        (1) 将zip文件解压
        (2) 配置环境变量
        (3) 在安装目录下新建data/db目录(数据存储目录)
        (4) 第一次启动在安装目录下执行如下命令, 以初始化数据库
            mongod --dbpath=..\data\db
    3. 服务端启动命令
        方式1 命令行启动
            在安装目录/bin下执行如下命令启动Mongodb:
                mongod --dbpath=..\data\db
        方式2 使用bat脚本启动
            @echo off
            cd D:\Software\develop\mongodb\bin && mongod --dbpath=..\data\db | findstr "port"
    4. 客户端启动命令
        将mongodb安装目录/bin配置为环境变量后, 终端执行如下命令
            mongo
## 常用的mongodb客户端连接工具
-->     [mongodb客户端连接工具](../../../../../_00_资源/_02_mongodb/robo3t-1.4.4-windows-x86_64-e6ac9ec5.zip)
    
    复制后直接使用即可
## Mongodb基本增删改查
    
    // 添加数据(文档)
    db.learn.save({
        "name": "springboot", 
        "type": "SpringBoot"
    })
    
    // 删除数据(文档), 删除所有name为SpringBoot的数据
    db.learn.remove({name: "SpringBoot"})
    
    // 修改数据(文档)
    // 修改一个
    db.learn.updateOne(
        {name: "springboot"},
        {$set:{name: "SpringBoot", type: "updateOne"}}
    )
    // 修改所有
    db.learn.updateMany(
        {name: "springboot"},
        {$set:{name: "SpringBoot", type: "updateMany"}}
    )
    // 查询数据
    db.learn().find();
    
## SpringBoot整合Mongodb
[SpringBoot整合Mongodb]
    [1-1 在pom中添加Mongodb依赖](../../../../pom.xml)
    [1-2 配置mongodb连接地址](../application.yml)