package com.bulldog.monkey.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import com.bulldog.monkey.entities.User;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryUser() {
        List<User> userList = userDao.queryUser();

        assertEquals(1, userList.size());
    }
}