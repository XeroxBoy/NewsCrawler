package com.invest.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.invest.dao.userDao;
import com.invest.pojo.User;

public class userService {
@Autowired
private userDao userdao;

private static SqlSessionFactory sqlSessionFactory;
private static Reader reader;
private static  ApplicationContext ctx;
static{
try{
	reader=Resources.getResourceAsReader("spring-mybatis.xml");
	sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
    ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

}
catch(Exception e){
	e.printStackTrace();
}
}
public void setUserdao(userDao userdao) {
	this.userdao = userdao;
}
public void insertUser(User user){
	SqlSession session=sqlSessionFactory.openSession();
	userdao=session.getMapper(userDao.class);
	userdao.insertUser(user);
	session.commit();
	session.close();
}
public void deleteUser(String username){
	SqlSession session=sqlSessionFactory.openSession();
	userdao=session.getMapper(userDao.class);
    userdao.deleteUser(username);
	session.commit();
    session.close();
}
public void  updateUser(User user)
{
	SqlSession session=sqlSessionFactory.openSession();
	userdao=session.getMapper(userDao.class);
	userdao.updateUser(user);
	session.commit();
	session.close();
}
public User selectUser(String username){
userService userService=(com.invest.service.userService) ctx.getBean("userService");
	SqlSession session=sqlSessionFactory.openSession();
/*	userdao=session.getMapper(userDao.class);
*/	User user=userService.selectUser(username);
	session.close();
	return user;
}
}
