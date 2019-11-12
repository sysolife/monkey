package com.bulldog.monkey.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.bulldog.monkey.annotations.PassToken;
import com.bulldog.monkey.annotations.UserLoginToken;
import com.bulldog.monkey.api.model.UserEntity;
import com.bulldog.monkey.api.model.UserEntityResult;
import com.bulldog.monkey.entity.User;
import com.bulldog.monkey.utils.JwtTokenUtil;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bulldog.monkey.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Michael
 * @create 2019-07-13 18:36
 */
@RestController
@RequestMapping("/api/v1/users")
@Api(tags = {"用户相关接口"}, value = "用户模块")
public class UserApiController {

    @Autowired
    private UserService userService;

    @PassToken
    @ApiOperation(value = "获取token", notes = "获取token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "string",example = "tom"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string",example = "123456")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HashMap<String, Object> login(String userName, String password) {
        HashMap<String, Object> hashMap = loginCheck(userName, password);
        if (Integer.parseInt(hashMap.get("code").toString()) == 0) {
            return hashMap;
        }
        String token = JwtTokenUtil.createJWT(hashMap.get("userId").toString(), "monkey", "user_id", 10000*60);
        hashMap.remove("userId");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("token", token);
        hashMap.put("data", data);
        return hashMap;
    }

    @UserLoginToken
    @ApiOperation(value = "获取用户列表", notes = "获取全部用户信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> getUsers() {
        List<User> list = userService.list();
        List<UserEntity> userEntityList = new ArrayList<UserEntity>();
        for (User user: list) {
            userEntityList.add(new UserEntity(user.getId(),user.getName()));
        };
        return userEntityList;
    }

    private HashMap<String, Object> loginCheck(String userName, String password) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (userName == null) {
            hashMap.put("code", 0);
            hashMap.put("message", "用户名为空!");
            return hashMap;
        }
        if (password == null) {
            hashMap.put("code", 0);
            hashMap.put("message", "密码为空!");
            return hashMap;
        }
        User user = userService.getByName(userName);
        if (user == null) {
            hashMap.put("code", 0);
            hashMap.put("message", "用户不存在！");
        } else {
            if (!password.equals(user.getPassword())) {
                hashMap.put("code", 0);
                hashMap.put("message", "密码不正确！");
            } else {
                hashMap.put("code", 1);
                hashMap.put("message", "获取token成功！");
                hashMap.put("userId", user.getId().toString());
            }
        }
        return hashMap;
    }
}

