package com.bulldog.monkey.web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bulldog.monkey.entities.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bulldog.monkey.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String, Object> listUser() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> list = new ArrayList<User>();
        // 获取区域列表
        list = userService.getUserList();
        modelMap.put("userList", list);
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @param areaStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private Map<String, Object> addUser(@RequestBody User area)
            throws JsonParseException, JsonMappingException, IOException {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", userService.addUser(area));
        return modelMap;
    }

}
