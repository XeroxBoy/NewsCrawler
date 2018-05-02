package com.invest.controller;

import com.invest.pojo.User;
import com.invest.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;

    @RequestMapping("/login")
    public ModelAndView userLogin(@ModelAttribute User user, HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView errorMav, mav;
        User oriUser=null;
        String username = user.getUsername();
        Subject subject = SecurityUtils.getSubject();
     /*   MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {

        }
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String pass=base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));*/
        UsernamePasswordToken token=new UsernamePasswordToken(username,user.getPassword());
       try {
           subject.login(token);
       }
       catch (AuthenticationException e){
           e.printStackTrace();
            errorMav=new ModelAndView("views/login.jsp");
           return errorMav;
       }
       // request.setAttribute("user",user);
//        try {
//            username = new String(username.getBytes("ISO-8859-1"), "utf-8");//转码
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

/*

        User user1=new User();
        user1.setEmail("123@qq.com");
        user1.setPassword("daohaode");
        user1.setUsername("abc");
        RedisCache cache = new RedisCache("1");
        cache.putObject("1", user1);

        User uu=(User) cache.getObject("1");
*/


/*        System.out.println(uu.getEmail()+" "+uu.getUsername()+" "+uu.getPassword());
        System.out.println();
        System.out.println();*/

    /*    String password = user.getPassword();
        if(username!=null)
            oriUser = userService.selectUser(username);*/
      //  if (oriUser!=null && oriUser.getPassword().equals(password) ) { //密码输入正确
            mav = new ModelAndView("redirect:/news/selectNews?pageNo=0");//跳转到用户界面


            mav.addObject("name", username);
            //mav.addObject("password", password);
            session.setAttribute("name", username);//把用户名保存在session中
            session.setAttribute("email",user.getEmail());
           // session.setAttribute("password",password);
            return mav;
     /*   } else {
            errorMav = new ModelAndView("views/login");//信息错误 重新登录
            errorMav.addObject("msg", "请重新输入");
            return errorMav;
        }*/
    }

    @RequestMapping("/userInfo")
    public ModelAndView userQuery(HttpSession session) {
        ModelAndView mav = new ModelAndView("views/MyInfo");
        User loginUser = userService.selectUser((String) session.getAttribute("name"));//从session中获取用户名并查询出信息
        if (loginUser != null) //如果存在用户 则将其返回给用户的view中
            mav.addObject("user", loginUser);
        return mav;
    }


    @RequestMapping("/zhuce")
    public ModelAndView userZhuce(@ModelAttribute User user) {
        ModelAndView errorMav, mav;
        String username = user.getUsername();
        String password = user.getPassword();

        User testUser = userService.selectUser(username); //查出用户信息 看是否注册过了
        if (testUser == null) { //如果这个用户帐号没有被注册过
            userService.insertUser(user);//注册成功
            mav = new ModelAndView("views/login");//跳转到登录界面
            return mav;
        } else {
            errorMav = new ModelAndView("views/zhuce");//跳转到注册界面
            errorMav.addObject("msg", "注册失败");
            return errorMav;
        }
    }

    @RequestMapping("/update")
    public ModelAndView userUpdate(@ModelAttribute User user) {
        ModelAndView mav, errorMav;
        mav = new ModelAndView("views/login");
        String username = user.getUsername();
        User testUser = userService.selectUser(username);//检查是否有该用户名，邮箱是否一致 若有 进行修改
        if (testUser == null || !testUser.getEmail().equals(user.getEmail())) {
            errorMav = new ModelAndView("views/update");
            errorMav.addObject("msg", "无此用户或您输错了邮箱");
            return errorMav;
        }
        userService.updateUser(user);
        mav.addObject("msg", "修改成功!");
        return mav;
    }
    /*
    * 头像上传
    * */
    @RequestMapping("/upload")
    public ModelAndView userUpload(@RequestParam("file") CommonsMultipartFile file,HttpSession session) throws IOException{
        try {
            File newFile=new File("E:/icon/"+ session.getAttribute("name") +".jpg");
            file.transferTo(newFile);//CommonsFile的上传方法

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("views/MyInfo");
    }
}
