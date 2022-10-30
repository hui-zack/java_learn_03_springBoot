
## 使用jdk创建并保存密钥(只使用http可以不做证书)
    
    具有jdk环境便可使用如下命令生成密钥并导出证书:
        生成密钥:
            keytool -genkey -v -alias tomcat -keyalg RSA -keystore D:\Software\develop\cas\jdkKeysStore\tomcat.keystore -validity 36500
                输入密钥库口令:
                再次输入新口令:
                您的名字与姓氏是什么?
                  [Unknown]:  localhost
                您的组织单位名称是什么?
                  [Unknown]:  hui
                您的组织名称是什么?
                  [Unknown]:  hui
                您所在的城市或区域名称是什么?
                  [Unknown]:  hui
                您所在的省/市/自治区名称是什么?
                  [Unknown]:  hui
                该单位的双字母国家/地区代码是什么?
                  [Unknown]:  hui
                CN=localhost, OU=hui, O=hui, L=hui, ST=hui, C=hui是否正确?
                  [否]:  y
                
                正在为以下对象生成 2,048 位RSA密钥对和自签名证书 (SHA256withRSA) (有效期为 36,500 天):
                         CN=localhost, OU=hui, O=hui, L=hui, ST=hui, C=hui
                输入 <tomcat> 的密钥口令
                        (如果和密钥库口令相同, 按回车):
                [正在存储D:\Software\develop\cas\jdkKeysStore\tomcat.keystore]
                                                                                                
        导出证书:
            keytool -export -trustcacerts -alias tomcat -file D:\Software\develop\cas\jdkKeysStore\caskey.cer -keystore D:\Software\develop\cas\jdkKeysStore\tomcat.keystore
                666666          // 输入自定义的密钥库密码
        将证书导入jdk证书库:
            keytool -import -trustcacerts -alias tomcat -file  D:\Software\develop\cas\jdkKeysStore\mykey.cer -keystore D:\Software\develop\Java\jdk-8u202\jre\lib\security\cacerts
                changeit        // 输入jdk的默认密码
    
    删除证书
        keytool -delete -alias tomcat -keystore cacerts
                
## CAS服务器的下载和安装
[cas-server 源码下载]
    [下载CAS server的代码](https://github.com/apereo/cas-overlay-template)

    5.3之后的版本为java1.8以上, 所以请下载5.3.xx
    
[在源码目录创建java和resource目录]

    将overlays\org.apereo.cas.cas-server-webapp-tomcat-5.3.16\WEB-INF\classes\application.properties复制到resource目录
        禁用sslkey验证:
           server.ssl.enabled=false
           #是否开启json识别功能,默认为false
           cas.serviceRegistry.initFromJson=true
           #忽略https安全协议，使用 HTTP 协议
           cas.tgc.secure=false
           
    将overlays\org.apereo.cas.cas-server-webapp-tomcat-5.3.16\WEB-INF\classes\services以及包含的文件复制到resource目录
        修改: resource\services\HTTPSandIMAPS-10000001.json
            "serviceId" : "^(https|imaps)://.*" 
            为
            "serviceId" : "^(https|http|imaps)://.*",
            
    注意: 必须复制过来, 否则打包(package)的时候所作的修改会被覆盖!
    
[cas服务器使用数据库]

    pom添加数据库依赖:
        <dependencies>
            <dependency>
                <groupId>org.apereo.cas</groupId>
                <artifactId>cas-server-support-jdbc</artifactId>
                <version>${cas.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apereo.cas</groupId>
                <artifactId>cas-server-support-jdbc-drivers</artifactId>
                <version>${cas.version}</version>
            </dependency>
        </dependencies> 
        
    配置文件application.properties设置数据源
        # 配置本地数据源
        cas.authn.jdbc.query[0].url=jdbc:mysql://localhost:3306/wsiva?serverTimezone=GMT
        cas.authn.jdbc.query[0].user=root
        cas.authn.jdbc.query[0].password=root
        cas.authn.jdbc.query[0].driverClass=com.mysql.jdbc.Driver
        cas.authn.jdbc.query[0].sql=select * from users where username = ?
        cas.authn.jdbc.query[0].fieldPassword=password
        logging.level.org.apereo=DEBUG
        cas.authn.jdbc.query[0].password-encoder.type=NONE
        cas.jdbc.showsql=true
    
## CAS-springBoot-client的安装和使用
[安装使用cas-client]
    [1-1 服务添加cas-client依赖](pom.xml)
    [1-2 在项目启动类上添加开启cas-client注解](./src/main/java/com/hui/SpringbootCasApplication.java)
    [1-3 在yml文件配置服务器验证地址](./src/main/resources/application.yml)

    
    
    