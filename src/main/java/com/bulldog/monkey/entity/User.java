package com.bulldog.monkey.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bulldog.monkey.enums.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String password;
    private UserSexEnum sex;
    private String nickName;

}
