package com.mashibing.mybatis.dao;

import com.mashibing.mybatis.dao.pojo.User;

import java.util.List;

public interface IUserDao {

    int  addUser(User user);
    int  updateUser(User user);
    int  deleteUser(Integer id);
    List<User> queryById(Integer id);
}
