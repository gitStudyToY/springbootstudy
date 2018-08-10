package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Body<T> implements Serializable{

    @JsonProperty("BUSI_INFO")
    public T busiInfo;

    public T getBusiInfo() {
        return busiInfo;
    }

    public void setBusiInfo(T busiInfo) {
        this.busiInfo = busiInfo;
    }
}