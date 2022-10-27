## 使用jdk创建并保存密钥
    
    具有jdk环境便可使用如下命令生成密钥并导出证书:
        生成密钥:
            keytool -genkey -v -alias java1234 -keyalg RSA -keystore D:\user\learn\java\jdkKeysStore\java1234.keystore
                输入密钥库口令: 666666                                                                                   
                再次输入新口令: 666666                                                                             
                您的名字与姓氏是什么?                                                                                 
                  [Unknown]:  java1234.com                                                                  
                您的组织单位名称是什么?                                                                                
                  [Unknown]:  java1234.com                                                                  
                您的组织名称是什么?                                                                                  
                  [Unknown]:  java1234.com                                                                  
                您所在的城市或区域名称是什么?                                                                             
                  [Unknown]:  chengdu                                                                       
                您所在的省/市/自治区名称是什么?                                                                           
                  [Unknown]:  sichuan                                                                       
                该单位的双字母国家/地区代码是什么?                                                                          
                  [Unknown]:  cn                                                                            
                CN=java1234.com, OU=java1234.com, O=java1234.com, L=chengdu, ST=sichuan, C=cn是否正确?          
                  [否]:  y     
                                                                                                
        导出证书:
            keytool -export -trustcacerts -alias java1234 -file D:\user\learn\java\jdkKeysStore\java1234.cer -keystore D:\user\learn\java\jdkKeysStore\java1234.keystore
                666666          // 输入自定义的密钥库密码
        将证书导入jdk证书库:
            keytool -import -trustcacerts -alias java1234 -file D:\user\learn\java\jdkKeysStore\java1234.cer -keystore D:\Software\develop\Java\jdk-8u202\jre\lib\security\cacerts
                changeit        // 输入jdk的默认密码
                
## CAS服务器的下载和安装
[cas war包下载]
    [下载CAS server的war包](https://repo1.maven.org/maven2/org/apereo/cas/cas-server-webapp-tomcat/)

    5.1.3之后的版本为java1.8以上, 所以请下载5.1.3
    
[tomcat配置https支持]

    conf/server.xml 添加如下内容以支持https
        <Connector port="8443" protocol="org.apache.coyote.http11.Http11AprProtocol"
            maxThreads="150" SSLEnabled="true" 
            scheme="https" secure="true"
            clientAuth="false" sslProtocol="TLS" 
            keystoreFile="D:\user\learn\java\jdkKeysStore\java1234.keystore"
            keystorePass="666666"
            />
    conf/logging.properties修改
        java.util.logging.ConsoleHandler.encoding = UTF-8 为 java.util.logging.ConsoleHandler.encoding = GBK
        
[cas server部署到tomcat]
    
    将war包部署到webapps下, 解压后修改部署目录名称为cas, https://localhost:8443/cas访问
        cas默认登录密码:
            casuser
            Mellon
            
[修改cas日志输出位置]

    修改文件内容: webapps\cas\WEB-INF\classes\log4j2.xml  修改日志输出位置
        <Properties>
            <Property name="baseDir">D:\Software\develop\cas\log</Property>
        </Properties>
        
[cas服务配置数据源, 数据库用户认证]

    webapps\cas\WEB-INF\classes\application.properties 
        注释掉该行(不使用默认写死的用户密码) cas.authn.accept.users=casuser::Mellon
    
        复制添加如下内容:
            # 配置本地数据源
            cas.authn.jdbc.query[0].url=jdbc:mysql://localhost:3306/wsiva?serverTimezone=GMT
            cas.authn.jdbc.query[0].user=root
            cas.authn.jdbc.query[0].password=root
            cas.authn.jdbc.query[0].sql=select * from users where username = ?
            cas.authn.jdbc.query[0].fieldPassword=password
            cas.authn.jdbc.query[0].driverClass=com.mysql.jdbc.Driver
            
[将认证jar包复制到cas服务系统依赖目录里]

    5.1.3版本的cas_server的四个jar包可在casNeededJar目录中复制
    
    将四个jar包复制到webapps\cas\WEB-INF\lib
        若需要其他版本的jar包可以通过添加依赖的方式下载, 然后在maven本地参考中找出来复制过去:
                    <dependency>
                        <groupId>org.apereo.cas</groupId>
                        <artifactId>cas-server-support-jdbc-drivers</artifactId>
                        <version>5.1.3</version>
                    </dependency>
            
                    <dependency>
                        <groupId>org.apereo.cas</groupId>
                        <artifactId>cas-server-support-jdbc-authentication</artifactId>
                        <version>5.1.3</version>
                    </dependency>
            
                    <dependency>
                        <groupId>org.apereo.cas</groupId>
                        <artifactId>cas-server-support-jdbc</artifactId>
                        <version>5.1.3</version>
                    </dependency>
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>5.1.32</version>
                    </dependency>
    


