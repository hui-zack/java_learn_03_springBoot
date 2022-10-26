package com.hui.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class HttpUtil {

    public void printRequestData(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("请求头: ");
        if (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println("    " + headerName + " = " + headerValue);
        }

        System.out.println("请求参数: ");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameter = request.getParameter(parameterName);
            System.out.println("    " + parameterName + " = " + parameter);
        }
    }
}
