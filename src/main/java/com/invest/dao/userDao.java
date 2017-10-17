package com.invest.dao;

import com.invest.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface userDao {
    public User selectUser(String username);

    public void deleteUser(String username);

    public void updateUser(User user);

    public void insertUser(User user);
}
