package org.example.demo.service;

import org.example.demo.pojo.User;
import org.example.demo.pojo.dto.UserDto;

import java.util.List;

public interface IUserService {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    User add(UserDto user);

    /**
     * 获取用户
     *
     * @param id 用户id
     * @return
     */
    User get(Integer id);

    /**
     * 编辑用户
     *
     * @param user 用户信息
     * @return
     */
    User edit(UserDto user);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void delete(Integer id);

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> getAll();
}
