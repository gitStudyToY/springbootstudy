package com.example.demo.controller;

import com.example.demo.dto.Root;
import com.example.demo.dto.param.DtoIn;
import com.example.demo.inter.DtoInter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DtoController {

    private static final Logger log = LoggerFactory.getLogger(DtoController.class);

    @Autowired
    private DtoInter dtoInter;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/dto")
    public String indto(@RequestBody Root<DtoIn> inparam) {

//        int i = 1/0;
//          //  dtoInter.indto(inparam);
        log.info(inparam.toString());
        log.info(inparam.getDto().getHeader().getChannel_Id() + "-----" + inparam.getDto().getHeader().getKeepLive());
        log.info(inparam.getDto().getBody().getBusiInfo().getCustId() + inparam.getDto().getBody().getBusiInfo().getOprInfo().get("CHANNEL_TYPE"));
        log.info(inparam.toJson(objectMapper));
        return inparam.getDto().getBody().getBusiInfo().getLoginNo();

    }

} 