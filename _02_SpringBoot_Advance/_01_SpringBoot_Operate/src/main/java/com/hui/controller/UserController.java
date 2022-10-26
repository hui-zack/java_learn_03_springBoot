package com.hui.controller;

import com.hui.controller.code.Code;
import com.hui.controller.dataResponse.Result;
import com.hui.domain.User;
import com.hui.service.UserService;
import com.hui.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpUtil httpUtil;

    /**
     * 查询所有
     * @return Json格式的Result对象, data为一个ArrayList<User>对象
     */
    @GetMapping

    public Result getAll(){
        List<User> users = userService.selectAll();
        Result result = new Result(Code.GET_OK, users);
        log.info(result.toString());
        return result;
    }

    /**
     * 根据id查询
     * @param id User表的id, 请求路径中获取
     * @return Json格式的Result对象, data为一个User对象
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        User user = userService.selectById(id);

        return new Result(Code.GET_OK, user);
    }

    /**
     * 添加
     * @param user json格式的user数据
     * @return Json格式的Result对象, data为一个Boolean
     */
    @PostMapping
    public Result Save(@RequestBody User user){
        Boolean flag = userService.insert(user);

        return new Result(Code.SAVE_OK, flag);
    }

    /**
     * 根据id删除
     * @param id User表的主键, 请求路径中获取
     * @return Json格式的Result对象, Data为一个Boolean
     */
    @DeleteMapping("/{id}")
    public Result DeleteById(@PathVariable Integer id){
        boolean flag = userService.deleteById(id);
        return flag ? new Result(Code.DELETE_OK, true) : new Result(Code.DELETE_ERROR, false, "不存在此id");
    }

    /**
     * 根据id修改
     * @param user 至少携带id值
     * @return Json格式的Result对象, Data为一个Boolean
     */
    @PutMapping
    public Result UpdateById(@RequestBody User user){
        Boolean flag = userService.updateById(user);
        return flag ? new Result(Code.UPDATE_OK, true) : new Result(Code.DELETE_ERROR, false, "不存在此id");
    }

    /**
     * 文件长传接口
     * @param fileUpload MultipartFile对象
     * @return Json格式的Result对象, Data为一个Boolean
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam(value = "file", required = false) MultipartFile fileUpload) throws IOException {

        String filename = fileUpload.getOriginalFilename();

        assert filename != null;
        String fileType = filename.substring(filename.lastIndexOf("."));
        String saveFilename = UUID.randomUUID() + fileType;
        String fileSaveDirPath = "D:\\user\\";

        fileUpload.transferTo(new File(fileSaveDirPath, saveFilename));
        return new Result(Code.SAVE_OK, true);

    }
}
