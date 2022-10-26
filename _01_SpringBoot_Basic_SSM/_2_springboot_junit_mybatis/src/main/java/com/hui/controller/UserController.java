package com.hui.controller;

import com.hui.domain.User;
import com.hui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    private User getById(@PathVariable Integer id){
        User user = userService.selectById(id);
        System.out.println(user.toString());
        return user;
    }
}
