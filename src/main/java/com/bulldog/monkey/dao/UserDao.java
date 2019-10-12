package com.bulldog.monkey.dao;

import java.util.List;
import com.bulldog.monkey.entities.User;

public interface UserDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<User> queryUser();

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    User queryUserById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return
     */
    int insertUser(User area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateUser(User area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    int deleteUser(int areaId);
}
