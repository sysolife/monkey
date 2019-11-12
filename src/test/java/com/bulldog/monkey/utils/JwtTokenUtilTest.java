package com.bulldog.monkey.utils;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenUtilTest {


    @Test
    public void createJwtToken(){
        String token = JwtTokenUtil.createJWT("1", "monkey", "user", 3600L);
        System.out.println(token);
    }

    @Test
    public void parseJwtToken(){
        String token = JwtTokenUtil.createJWT("1", "monkey", "user", 3600L);
        System.out.println(token);
        Claims claims = JwtTokenUtil.decodeJWT(token);
    }
}