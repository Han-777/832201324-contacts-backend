// src/main/java/org/example/demo/controller/UserController.java

package org.example.demo.controller;

import org.example.demo.pojo.User;
import org.example.demo.pojo.dto.UserDto;
import org.example.demo.pojo.dto.ResponseMessage;
import org.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin // Configure CORS as needed
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseMessage<User> addUser(@RequestBody UserDto userDto) {
        User user = userService.add(userDto);
        return ResponseMessage.success(user);
    }

    @GetMapping("/{id}")
    public ResponseMessage<User> getUser(@PathVariable Integer id) {
        User user = userService.get(id);
        return ResponseMessage.success(user);
    }

    @PutMapping("/{id}")
    public ResponseMessage<User> editUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        userDto.setUserId(id); // Ensure ID consistency
        User user = userService.edit(userDto);
        return ResponseMessage.success(user);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Void> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseMessage.success();
    }

    @GetMapping
    public ResponseMessage<Page<User>> getAllUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search
    ) {
        // PageRequest pages are zero-based
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<User> users = userService.getAll(pageRequest, search);
        return ResponseMessage.success(users);
    }
}