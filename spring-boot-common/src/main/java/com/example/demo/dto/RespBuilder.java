package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespBuilder {
    public static  Builder builder() {
        return new Builder();
    }

    public static class Builder {
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
        public <T> RootResp<T> build(T requestObject) {
            RootResp<T> response = new RootResp<>();
            response.getBody().setReturnCode(returnCode);
            response.getBody().setReturnMsg(returnMsg);
            response.getBody().setOutData(requestObject);
//            response.getDto().getBody().setDetailMsg(detailMsg);
//            response.getDto().getBody().setPromptMsg(promptMsg);
//            response.getDto().getBody().setRunIp(runIp);
//            response.getDto().getBody().setUserMsg(userMsg);

            return response;
        }

        public Builder returnCode(String returnCode) {
            this.returnCode = returnCode;
            return this;
        }

        public Builder returnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
            return this;
        }
    }

} 