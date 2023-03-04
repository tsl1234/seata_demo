package com.demo.controller;

import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/v1/consumer/delete")
    public void delete(){
        int i =1/0;
        userMapper.deleteUser(1);
    }
}
