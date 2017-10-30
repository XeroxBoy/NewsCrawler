package com.invest.controller;

import com.invest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.invest.service.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;
    @RequestMapping("/login")
    public ModelAndView userLogin(@ModelAttribute User user, HttpSession session) {
        ModelAndView errorMav, mav;
        User oriUser=null;
        String username = user.getUsername();
        String password = user.getPassword();
        if(username!=null)
            oriUser = userService.selectUser(username);
        if (oriUser.getPassword().equals(password) && oriUser!=null) { //密码输入正确
            mav = new ModelAndView("redirect:/news/selectNews?pageNo=1");//跳转到用户界面
            mav.addObject("name", username);
            mav.addObject("password", password);
            session.setAttribute("name", username);//把用户名保存在session中
            return mav;
        } else {
            errorMav = new ModelAndView("views/login");//信息错误 重新登录
            errorMav.addObject("msg", "请重新输入");
            return errorMav;
        }
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
}
