package com.hui.interceptor;

import com.hui.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 1-3-4 编写拦截器拦截所有请求进行统计 */
public class IpCountInterceptor implements HandlerInterceptor {
    @Autowired
    private IpCountService ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCountService.count();
        return true;
    }

}
