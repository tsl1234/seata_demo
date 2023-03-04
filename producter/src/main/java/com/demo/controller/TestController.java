package com.demo.controller;

import com.demo.mapper.UserMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping(value = "/v1/consumer/delte")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String delete(){

        userMapper.deleteUser(1);
        ResponseEntity<String> exchange = new RestTemplate().exchange("http://localhost:9001/v1/consumer/delete", HttpMethod.GET, null, String.class);
        return "success";
    }
}
