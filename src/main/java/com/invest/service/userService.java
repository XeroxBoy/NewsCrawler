package com.invest.service;

import com.invest.dao.userDao;
import com.invest.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Reader;

@Service("userService")
public class userService {
    @Resource
    private userDao userdao;

    /*
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;*/
//private static  ApplicationContext ctx;
/*static{
try{
	reader=Resources.getResourceAsReader("spring-mybatis.xml");
	sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
  //  ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

}
catch(Exception e){
	e.printStackTrace();
}
}*/
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
