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
            mav = new ModelAndView("views/News");
            mav.addObject("name", username);
            mav.addObject("password", password);
            return mav;
        } else {
            errorMav = new ModelAndView("views/index");
            errorMav.addObject("msg", "请重新输入");
            return errorMav;
        }
    }
}
