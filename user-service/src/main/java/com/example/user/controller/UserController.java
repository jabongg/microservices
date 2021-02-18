package com.example.user.controller;

import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser : UserController");
        return userService.saveUser(user);
    }

/*
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        log.info("inside getUserById : UserController");
        return userService.getUserById(userId);
    }
*/

    @GetMapping("/{id}")
    public ResponseTemplateVO getDepartmentForUser(@PathVariable("id") Long userId) {
        log.info("inside getDepartmentForUser : UserController");

        return userService.getDepartmentForUser(userId);
    }
}
