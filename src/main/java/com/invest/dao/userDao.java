package com.invest.dao;

import org.springframework.stereotype.Component;

import com.invest.pojo.User;
@Component
public interface userDao {
public User selectUser(String username);
public void deleteUser(String username);
public void updateUser(User user);
public void insertUser(User user);
}
