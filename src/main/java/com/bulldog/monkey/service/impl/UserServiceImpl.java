package com.bulldog.monkey.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bulldog.monkey.entity.User;
import com.bulldog.monkey.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bulldog.monkey.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String userName) {
        return userMapper.getByName(userName);
    }

    @Override
    public boolean verifyPassword(String userName,String password){
        return true;
    };
}