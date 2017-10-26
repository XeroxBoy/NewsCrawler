package com.invest.service;

import com.invest.dao.userDao;
import com.invest.pojo.User;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class userService {
    @Resource
    private userDao userdao;
    public void insertUser(User user) {
        userdao.insertUser(user);
    }

    public void deleteUser(String username) {
        userdao.deleteUser(username);
    }

    public void updateUser(User user) {
        userdao.updateUser(user);
    }

    public User selectUser(String username) {
        User user = userdao.selectUser(username);
        return user;
    }
}
