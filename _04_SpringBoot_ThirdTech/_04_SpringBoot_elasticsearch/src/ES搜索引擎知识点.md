## ES简介
    1. Elasticsearch是一个分布式全文搜索引擎
   
    2. ES搜索引擎中的倒排索引:
        传统数据库的索引的索引根据id查数据, ES的倒排索引是根据关键字查id, id查数据
    3. ES文档:
        创建文档:
        使用文档: 
        
## ES_windows版下载
.   [windows版ES下载地址](https://www.elastic.co/cn/downloads/elasticsearch)

[ES的安装和启动]

    ES的安装:
        下载后为zip压缩文件, 直接解压即可
    修改配置文件: 
        config/wlasticsearch
            xpack.security.enabled: false       //关闭ssl认证
    启动文件: 
        bin/elasticsearch.bat
    ES的默认启动端口是: 9200
    
[ES的常用接口]
    
    版本控制接口: localhost:9200
    创建索引库接口: localhost:9200/books
    
        