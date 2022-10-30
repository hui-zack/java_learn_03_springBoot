package com.hui;




import org.jasig.cas.client.boot.configuration.EnableCasClient;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/* 1-2 在项目启动类上添加开关注解并指定使用casServer数据源 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCasClient
@SpringBootApplication
public class SpringbootCasApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringbootCasApplication.class, args);
    }
//    @GetMapping("/a")
//    public String  root(HttpServletRequest request){
//        HttpSession session = request.getSession();
////        if (null != session && session.getAttribute("_const_cas_assertion_") != null) {
////
////            Assertion assertion = (Assertion) session.getAttribute("_const_cas_assertion_");
////            Map<String, Object> attributes = assertion.getPrincipal().getAttributes();
////            System.out.println(assertion);
////            System.out.println(attributes);
////        }
//
//        return "demo";
//    }
//
//    public void logout(){
//
//    }

}
