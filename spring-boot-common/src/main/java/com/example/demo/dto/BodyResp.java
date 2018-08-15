package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;


public class BodyResp<T> implements Serializable{

    /**
     * 响应码
     */
    @JsonProperty("RETURN_CODE")
    public String returnCode;

    /**
     * 响应消息描述
     */
    @JsonProperty("RETURN_MSG")
    public String returnMsg;

    @JsonProperty("USER_MSG")
    public String userMsg;

    @JsonProperty("DETAIL_MSG")
    public String detailMsg;

    @JsonProperty("RUN_IP")
    public String runIp;

    @JsonProperty("PROMPT_MSG")
    public String promptMsg;

    @JsonProperty("OUT_DATA")
    public T outData;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public String getRunIp() {
        return runIp;
    }

    public void setRunIp(String runIp) {
        this.runIp = runIp;
    }

    public String getPromptMsg() {
        return promptMsg;
    }

    public void setPromptMsg(String promptMsg) {
        this.promptMsg = promptMsg;
    }

    public T getOutData() {
        return outData;
    }

    public void setOutData(T outData) {
        this.outData = outData;
    }
}