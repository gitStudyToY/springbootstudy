package com.example.demo.exception;

import com.example.demo.dto.RespBuilder;
import com.example.demo.dto.RootResp;
import com.example.demo.dto.param.DtoOut;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultErrorHandler(Exception e,NativeWebRequest webRequest){


//        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
//        ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(request);
//
//        Map<String, Object> errors = new LinkedHashMap();
//
////		URI uri = ServletUriComponentsBuilder.fromServletMapping(request).build().toUri();
//        URI uri = ServletUriComponentsBuilder.fromRequest(request).build().toUri();
//        errors.put("requestPath", uri.toString());
//
//        log.error("AppException, requestPath:{}, requestHeader:{}, Exception:{}",
//                uri.toString(), inputMessage.getHeaders(), e);
//
//
//        Object errorObj = messageSchema.defaultError(t, errors);
//
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        header.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON_UTF8));
        RootResp rootResp = RespBuilder.builder().returnMsg("异常：").returnCode("1").build(e.getClass());
        ResponseEntity<Object> resp = new ResponseEntity<Object>(rootResp, HttpStatus.OK);
        log.info("捕获到异常：" + e.getClass());
        log.info(ExceptionUtils.getFullStackTrace(e));
       // log.info(resp.toJson(objectMapper));

        return resp;
    }


//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }

//    @ExceptionHandler(value = MyException.class)
//    @ResponseBody
//    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
//        ErrorInfo<String> r = new ErrorInfo<>();
//        r.setMessage(e.getMessage());
//        r.setCode(ErrorInfo.ERROR);
//        r.setData("Some Data");
//        r.setUrl(req.getRequestURL().toString());
//        return r;
//    }


}