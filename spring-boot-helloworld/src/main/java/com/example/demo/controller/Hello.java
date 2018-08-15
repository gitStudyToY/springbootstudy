package com.example.demo.controller;

import com.example.demo.dto.RootResp;
import com.example.demo.inter.HelloInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private HelloInter helloInter;

    @GetMapping("/hello")
    public RootResp hello(){

        return helloInter.hello();
    }

} 