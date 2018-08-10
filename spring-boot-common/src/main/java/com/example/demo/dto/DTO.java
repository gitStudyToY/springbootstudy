package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.Objects;

@JsonRootName("ROOT")
public class DTO<T> {

    /**
     * 会话控制
     */
    @JsonProperty(value="HEADER")
    private Header header;

    /**
     * 业务内容
     */
    @JsonProperty(value="BODY")
    private Body<T> body;


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body<T> getBody() {
        if (Objects.isNull(body)) {
            this.body = new Body<T>();
        }
        return body;
    }

    public void setBody(Body<T> body) {
        this.body = body;
    }

}