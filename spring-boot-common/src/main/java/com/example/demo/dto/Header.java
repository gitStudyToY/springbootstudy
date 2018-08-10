package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class Header implements Serializable{

    @JsonProperty("CHANNEL_ID")
    public String channel_Id;

    @JsonProperty("KEEP_LIVE")
    public String keepLive;

    public String getChannel_Id() {
        return channel_Id;
    }

    public void setChannel_Id(String channel_Id) {
        this.channel_Id = channel_Id;
    }

    public String getKeepLive() {
        return keepLive;
    }

    public void setKeepLive(String keepLive) {
        this.keepLive = keepLive;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}