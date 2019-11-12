package com.bulldog.monkey.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bulldog.monkey.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void categoryList(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void selectByName(){
        User user = userMapper.selectByName("tom");
        System.out.println(user.getId());
    }

    @Test
    public void selectListByPage(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "t");

        Page<User> userPage = new Page<User>(1, 2);
        IPage<User> iPage = userMapper.selectPage(userPage,queryWrapper);
        System.out.println(iPage.getPages());
        System.out.println(iPage.getTotal());
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }
}