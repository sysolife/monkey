package com.bulldog.monkey.entities;

import com.bulldog.monkey.enums.UserSexEnum;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String password;
    private UserSexEnum sex;
    private String nickName;

    public User() {
        super();
    }

    public User(String userName, String password, UserSexEnum sex) {
        super();
        this.password = password;
        this.userName = userName;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public UserSexEnum getUserSex() {
        return sex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.sex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "userName " + this.userName + ", password " + this.password + "sex " + this.sex.name();
    }

}
