package com.example.demo.dto.param;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DtoIn {

    @JsonProperty("LOGIN_NO")
    private String LoginNo;
    @JsonProperty("CUST_ID")
    private String custId;

    @JsonProperty("OPR_INFO")
    private Map<String,Object>  oprInfo;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Map<String, Object> getOprInfo() {
        return oprInfo;
    }

    public void setOprInfo(Map<String, Object> oprInfo) {
        this.oprInfo = oprInfo;
    }

    public String getLoginNo() {
        return LoginNo;
    }

    public void setLoginNo(String loginNo) {
        LoginNo = loginNo;
    }
}