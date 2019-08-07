package com.hair.controller;


import com.hair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/testFeign/{emoji}")
    public Object testFeign(@PathVariable String emoji){
       return userService.judgeEmoji(emoji);
    }
}
