package com.bulldog.monkey.service;
import java.util.List;

import com.bulldog.monkey.entities.User;

public interface UserService {

    /**
     * 获取区域列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 通过区域Id获取区域信息
     *
     * @param areaId
     * @return
     */
    User getUserById(int areaId);

    /**
     * 增加区域信息
     *
     * @param area
     * @return
     */
    boolean addUser(User area);

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    boolean modifyUser(User area);

    /**
     * 删除区域信息
     *
     * @param area
     * @return
     */
    boolean deleteUser(int areaId);

}