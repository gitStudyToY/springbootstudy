package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class Root<T> implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(DTO.class);

    /**
     *
     */
    private static final long serialVersionUID = 5819991946390023007L;

    @JsonProperty("ROOT")
    private DTO<T> dto;

    public DTO<T> getDto() {
        return dto;
    }

    public void setDto(DTO<T> dto) {
        this.dto = dto;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJson(ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.error("", e);
        }
        return toString();
    }
}