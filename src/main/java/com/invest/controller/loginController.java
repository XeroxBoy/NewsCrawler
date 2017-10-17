package com.invest.controller;

import com.invest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.invest.service.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class loginController {
    @Autowired
    private userService userService;

    @RequestMapping("/user.do")
    public ModelAndView userLogin(@ModelAttribute User user) {
        ModelAndView errorMav, mav;
        String username = user.getUsername();
        String password = user.getPassword();
        User oriUser = userService.selectUser(username);
        if (oriUser.getPassword().equals(password)) {
            mav = new ModelAndView("views/News");//跳转到用户界面
            mav.addObject("name", username);
            mav.addObject("password", password);
            return mav;
        } else {
            errorMav = new ModelAndView("views/index");
            errorMav.addObject("msg", "请重新输入");
            return errorMav;
        }
    }

    @RequestMapping("/zhuce.do")
    public ModelAndView userZhuce(@ModelAttribute User user) {
        ModelAndView errorMav, mav;
        String username = user.getUsername();
        String password = user.getPassword();
        User testUser = userService.selectUser(username);
        if (testUser != null) { //如果这个用户帐号没有被注册过
            userService.insertUser(user);//注册成功
            mav = new ModelAndView("views/index");//跳转到登录界面
            return mav;
        } else {
            errorMav = new ModelAndView("views/zhuce");//跳转到注册界面
            errorMav.addObject("msg", "注册失败");
            return errorMav;
        }
    }
    @RequestMapping("/update.do")
    public ModelAndView userUpdate(@ModelAttribute User user){
        ModelAndView  mav,errorMav;
        mav=new ModelAndView("views/index");
        String username=user.getUsername();
        User testUser=userService.selectUser(username);//检查是否有该用户名 若有 进行修改
        if(testUser==null) {
            errorMav=new ModelAndView("views/update");
            errorMav.addObject("msg","无此用户");
            return errorMav;
        }
        userService.updateUser(user);
        mav.addObject("msg","修改成功!");
        return mav;
    }
}
