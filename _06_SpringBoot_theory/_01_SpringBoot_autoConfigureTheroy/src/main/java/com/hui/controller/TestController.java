package com.hui.controller;

import com.hui.config.IpCountConfig;
import com.hui.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private IpCountService ipCountService;
    @Autowired
    private IpCountConfig ipCountConfig;

    @GetMapping("ipTest")
    public String ipTest(){
//        System.out.println(ipCountConfig.toString());
//        ipCountService.count();

        return "true";
    }
}
