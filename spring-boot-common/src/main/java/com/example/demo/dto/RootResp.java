package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

@JsonRootName(value = "ROOT")
public class RootResp<T> implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(DTO.class);

    /**
     *
     */
    private static final long serialVersionUID = 5819991946390023007L;

//    @JsonProperty("ROOT")
//    private DTOResp<T> dto;
//
//    public DTOResp<T> getDto() {
//        return dto;
//    }
//
//    public void setDto(DTOResp<T> dto) {
//        this.dto = dto;
//    }

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


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJson(ObjectMapper objectMapper) {
        try {
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.error("", e);
        }
        return toString();
    }

} 