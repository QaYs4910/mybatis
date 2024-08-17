package com.mashibing.mybatis.dao.impl;

import com.mashibing.mybatis.dao.IUserDao;
import com.mashibing.mybatis.dao.pojo.User;
import com.mashibing.mybatis.utils.DbUtils;

import java.util.List;

public class UserDaoimpl implements IUserDao {


    public int addUser(User user) {
        return DbUtils.getInstance().openSession().insert("com.mashibing.mybatis.dao.IUserDao.addUser",user);
    }

    public int updateUser(User user) {
        return DbUtils.getInstance().openSession().insert("com.mashibing.mybatis.dao.IUserDao.updateUser",user);
    }

    public int deleteUser(Integer id) {
        return DbUtils.getInstance().openSession().insert("com.mashibing.mybatis.dao.IUserDao.updateUser",id);
    }

    public List<User> queryById(Integer id) {
        return DbUtils.getInstance().openSession().selectList("com.mashibing.mybatis.dao.IUserDao.queryById", id);
    }
}
