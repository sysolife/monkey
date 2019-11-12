package com.bulldog.monkey.api.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class TokenExceptionHandler {
    @ResponseBody
    @ExceptionHandler(TokenException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("message",e.getMessage());
        return map;
    }

}