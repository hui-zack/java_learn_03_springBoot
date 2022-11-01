package com.hui.controller;



import com.hui.config.cas.LoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class IndexController {

    @Autowired
    private LoginConfig loginConfig;


    /* 前端访问该接口进行跳转(不能是axios请求, 只能是window.location.href = "http://xx.xx.xx.xx:port") */
    @GetMapping("/")
    public String jumpPage(@Autowired HttpServletRequest request){
        String casWebHomePageUrl = loginConfig.getCasWebHomePageUrl();
        return "<head><meta http-equiv=\"refresh\" content=\"0.1;url=" + casWebHomePageUrl + "\"></head>";
    }

    /* 该接口不被cas拦截, 前端访问该接口获取登录类型(cas登录或本地登录) */
    @PostMapping("/api/loginType")
    public Object loginType(@Autowired HttpServletRequest request, @Autowired HttpServletResponse response){
        HashMap<String, Object> valueMap = new HashMap<>();

        if (loginConfig.getCas()){
            valueMap.put("loginType", "cas");
            valueMap.put("loginUrl", request.getRequestURL().toString().replace(request.getRequestURI(), ""));

            HttpSession session = request.getSession();
            valueMap.put("result", null != session && session.getAttribute("_const_cas_assertion_") != null);

            return valueMap;
        } else {

            try {
                request.getRequestDispatcher("/api/user/verify").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
    /* 当登录方式为本地登录时, 请求将从/loginType转发到这里 */
    @PostMapping("/api/user/verify")
    public Object tokenVerify(@RequestBody HashMap<String, Object> requestMap, @Autowired HttpServletResponse response){

        HashMap<String, Object> valueMap = new HashMap<>();
        boolean verify;
        if (!requestMap.containsKey("token")){
            requestMap.put("token", null);
        }

        String token = (String) requestMap.get("token");
        verify = verify(token);

        if (loginConfig.getCas()){
            verify = true;
        }

        String loginType = loginConfig.getCas() ? "cas" : "local";
        String msg = verify ? "验证成功" : "验证失败";
        valueMap.put("msg", msg);
        valueMap.put("result", verify);
        valueMap.put("loginType", loginType);

        return valueMap;
    }

    /* 访问本接口进行cas登出, 注意前端使用axios请求的话必须先配置axios支持cookie, 才能从cas登出 */
    @GetMapping("/logout")
    public Object logout(HttpSession session, HttpServletResponse response) throws IOException {
        HashMap<String, Object> valueMap = new HashMap<>();
        if (loginConfig.getCas()) {
            String loginType = "cas";

            valueMap.put("loginType", loginType);
            session.invalidate();
            response.sendRedirect(loginConfig.getCasServerUrlPrefix() + "/logout");
        }

        return valueMap;
    }

    private Boolean verify(String token){
        return true;
    }

}
