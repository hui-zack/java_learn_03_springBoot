package com.hui.controller;



import org.jasig.cas.client.validation.Assertion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
public class IndexController {


    @GetMapping("/a")
    public String  root(HttpServletRequest request){

        return "demo";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();

        if (null != session && session.getAttribute("_const_cas_assertion_") != null) {

            Assertion assertion = (Assertion) session.getAttribute("_const_cas_assertion_");
            Map<String, Object> attributes = assertion.getPrincipal().getAttributes();
            System.out.println(assertion);
            System.out.println(attributes);
        }

        return "ok";
    }

    @GetMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("http://localhost:10086/cas/logout");
    }
}
