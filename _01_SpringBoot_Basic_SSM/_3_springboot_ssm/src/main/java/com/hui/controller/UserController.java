package com.hui.controller;

import com.hui.controller.code.Code;
import com.hui.controller.dataResponse.Result;
import com.hui.domain.User;
import com.hui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result add(@RequestBody User user) {
        boolean flag = userService.add(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERROR, flag);
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERROR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERROR, flag);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.selectById(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = user != null ? "" : "数据查询失败";
        return new Result(code, user, msg);
    }

    @GetMapping
    public Result selectAll() {
        List<User> userList = userService.selectAll();
        Integer code = userList != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = userList != null ? "" : "数据查询失败";
        return new Result(code, userList, msg);
    }
}
