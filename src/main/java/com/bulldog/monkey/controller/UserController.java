package com.bulldog.monkey.controller;


import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bulldog.monkey.annotations.UserLoginToken;
import com.bulldog.monkey.entity.User;
import com.bulldog.monkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bulldog.monkey.utils.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
/**
 * UserController
 *
 * @author lijian
 * @date 2019/11/3
 */
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/form_login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,Model model) {
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        System.out.println(user_name);
        System.out.println(password);
        HttpSession session = request.getSession(true);
        session.setAttribute("userName", user_name);
        model.addAttribute("message","hello freemarker");
        return "layouts/application";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request,Model model) {
        String userName = (String) request.getSession().getAttribute("userName");
        model.addAttribute("userName",userName);
        request.getCookies();
        return "users/hello";
    }


    @RequestMapping(value = "/form_login_out", method = RequestMethod.POST)
    public String loginOut(HttpServletRequest request) {
        return "users/login";
    }
}
