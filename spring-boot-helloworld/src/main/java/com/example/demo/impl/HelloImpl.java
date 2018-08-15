package com.example.demo.impl;

import com.example.demo.dto.RootResp;
import com.example.demo.inter.HelloInter;
import org.springframework.stereotype.Service;

@Service
public class HelloImpl implements HelloInter {

    @Override
    public RootResp hello() {
        int i = 1/0;
        RootResp rootResp = new RootResp();

        return rootResp;
    }
}