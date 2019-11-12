package com.bulldog.monkey.api.interceptores;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bulldog.monkey.annotations.PassToken;
import com.bulldog.monkey.annotations.UserLoginToken;
import com.bulldog.monkey.api.exception.TokenException;
import com.bulldog.monkey.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 执行认证
        if (token == null) {
            throw new TokenException("无token，请先获取token");
        }
        try {
            Claims claims = JwtTokenUtil.decodeJWT(token);
        } catch (Exception e) {
            throw new TokenException(e.getMessage());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }


    private void responseJson(HttpServletResponse httpServletResponse) {
        // httpServletResponse.setCharacterEncoding("UTF-8");
        // httpServletResponse.setContentType("application/json; charset=utf-8");
        // JSONObject res = new JSONObject();
        // res.put("status","-1");
        // res.put("msg","need login");
        // PrintWriter out = null ;
        // out = httpServletResponse.getWriter();
        // out.write(res.toString());
        // out.flush();
        // out.close();
    }


    /**
     * @param  httpServletRequest
     * @return String
     * @title 从请求中获取参数
     * @description
     * @author lijian
     * @date 2019-11-08
     */
    private String getTokenStr(HttpServletRequest httpServletRequest) {
        String token;
        String method = httpServletRequest.getMethod();
        if (method.equals(RequestMethod.GET)) {
            token = httpServletRequest.getParameter("token");
        } else {
            try (BufferedReader reader = httpServletRequest.getReader()) {
                StringBuilder sb = new StringBuilder();
                String s;
                while ((s = reader.readLine()) != null) {
                    sb.append(s.trim());
                }
                JSONObject jsonObject = JSON.parseObject(sb.toString());
                token = jsonObject.getString("token");
            }catch (Exception e){
                token = "";
            }
        }
        return token;
    }
}