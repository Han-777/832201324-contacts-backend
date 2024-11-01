package org.example.demo.controller;

import org.example.demo.pojo.User;
import org.example.demo.pojo.dto.ResponseMessage;
import org.example.demo.pojo.dto.UserDto;
import org.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController // 接口方法返回对象， 转换成json文本返回前端（开发中需要将后端的数据转换成json文本方便客户端进行处理）
@RequestMapping("/user") // localhost:8080/user/** （路由映射，接收前端请求）
@CrossOrigin(origins = "*", maxAge = 3600) // 允许跨域请求
public class UserController {

    @Autowired
    IUserService userService;
    // Rest
    // add
    @PostMapping // 前端请求地址：   URL: localhost:8080/user   method: POST
    public ResponseMessage<Object> add(@Validated @RequestBody UserDto user){ // DTO数据传输类，接收前端传递的数据
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }

    // query
    @GetMapping("/{id}") // localhost:8080/user/1
    public ResponseMessage<Object> get(@PathVariable Integer id){
        User user = userService.get(id);
        return ResponseMessage.success(user);
    }
    @GetMapping
    public ResponseMessage<Object> getAll(){
        List<User> userList = userService.getAll();
        return ResponseMessage.success(userList);
    }
    // edit
    @PutMapping // localhost:8080/user/1
    public ResponseMessage<Object> edit(@Validated @RequestBody UserDto user){
        User userNew = userService.edit(user);
        return ResponseMessage.success(userNew);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseMessage<Object> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseMessage.success();
    }

}
