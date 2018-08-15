package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Objects;

public class DTOResp<T> implements Serializable {

    /**
     * 会话控制
     */
    @JsonProperty(value="HEADER")
    private Header header;

    /**
     * 业务内容
     */
    @JsonProperty(value="BODY")
    private BodyResp<T> body;


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BodyResp<T> getBody() {
        if (Objects.isNull(body)) {
            this.body = new BodyResp<T>();
        }
        return body;
    }

    public void setBody(BodyResp<T> body) {
        this.body = body;
    }

} 