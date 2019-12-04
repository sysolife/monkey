package com.bulldog.monkey.api.controller;

import com.bulldog.monkey.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijian
 * @ClassName BaseController
 * @description API的基类，封装常用的方法
 * @date 2019-12-04
 */
public class BaseController {

    /**
     * httpServletRequest,httpServletResponse 线程安全直接引入。
     */
    @Autowired
    protected HttpServletRequest httpServletRequest;

    @Autowired
    protected HttpServletResponse httpServletResponse;

    /**
     * 获取用户userId
     *
     * @return
     */
    protected Integer getCurrentUserId() {
        String token = httpServletRequest.getHeader("token");
        String userId =  JwtTokenUtil.decodeJWT(token).getId();
        return Integer.parseInt(userId);
    }

    /**
     * 获取token
     *
     * @return
     */
    protected String getToken() {
        String token = httpServletRequest.getHeader("token");
        return token;
    }
}
