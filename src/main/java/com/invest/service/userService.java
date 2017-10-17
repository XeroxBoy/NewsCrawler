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
    /*SqlSession session=sqlSessionFactory.openSession();
    userdao=session.getMapper(userDao.class);*/
        userdao.insertUser(user);
	/*session.commit();
	session.close();*/
    }

    public void deleteUser(String username) {
/*	SqlSession session=sqlSessionFactory.openSession();
	userdao=session.getMapper(userDao.class);*/
        userdao.deleteUser(username);
/*	session.commit();
    session.close();*/
    }

    public void updateUser(User user) {
	/*SqlSession session=sqlSessionFactory.openSession();
	userdao=session.getMapper(userDao.class);*/
        userdao.updateUser(user);
	/*session.commit();
	session.close();*/
    }

    public User selectUser(String username) {
//userService userService=(com.invest.service.userService) ctx.getBean("userService");
/*	SqlSession session=sqlSessionFactory.openSession();
	userdao=session.getMapper(userDao.class);*/
        User user = userdao.selectUser(username);
/*
	session.close();
*/
        return user;
    }
}
