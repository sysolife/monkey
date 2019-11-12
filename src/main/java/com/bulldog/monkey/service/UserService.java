package com.bulldog.monkey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bulldog.monkey.entity.User;

public interface UserService extends IService<User> {
    User getByName(String userName);
    boolean verifyPassword(String userName,String password);
}