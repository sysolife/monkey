package com.bulldog.monkey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bulldog.monkey.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByName(String name);
    User getByName(String name);
}