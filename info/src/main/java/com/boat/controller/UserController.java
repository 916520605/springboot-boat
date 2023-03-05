package com.boat.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.boat.entity.User;
import com.boat.service.UserService;

import cn.dev33.satoken.util.SaResult;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/3/3 22:09
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/doLogin")
    public SaResult login(@RequestBody User user) {
        return this.userService.selectUser(user);
    }
}
