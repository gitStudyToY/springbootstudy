package com.example.demo.impl;

import com.example.demo.dto.DTO;
import com.example.demo.dto.param.DtoIn;
import com.example.demo.inter.DtoInter;
import org.springframework.stereotype.Service;

@Service
public class DtoImpl implements DtoInter {

    @Override
    public String indto(DTO<DtoIn> inparam) {
        return "";
    }
}