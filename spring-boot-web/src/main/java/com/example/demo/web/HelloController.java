package com.example.demo.web;

import com.example.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception{
        throw new Exception("发生错误！");
    }

    @RequestMapping("/json")
    public String json() throws MyException{
        throw new MyException("发生错误2！");
    }

} 