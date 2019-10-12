package com.bulldog.monkey.service.impl;



import java.util.Date;
import java.util.List;

import com.bulldog.monkey.dao.UserDao;
import com.bulldog.monkey.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bulldog.monkey.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        // 返回所有的区域信息
        return userDao.queryUser();
    }

    @Override
    public User getUserById(int userId) {
        return userDao.queryUserById(userId);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        // 空值判断，主要是判断areaName不为空
        if (user.getName() != null && !"".equals(user.getName())) {
            // 设置默认值
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyUser(User user) {
        // 空值判断，主要是areaId不为空
        if (user.getId() != null && user.getId() > 0) {
            // 设置默认值
            user.setUpdatedAt(new Date());
            try {
                // 更新区域信息
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(int userId) {
        if (userId > 0) {
            try {
                // 删除区域信息
                int effectedNum = userDao.deleteUser(userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}