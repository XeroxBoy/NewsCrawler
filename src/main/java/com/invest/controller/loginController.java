package com.invest.controller;

import com.invest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.invest.service.*;
@Controller
@RequestMapping("/login")
public class loginController {
     private User user;
	@Autowired
	private userService userService;
	@RequestMapping("/user.do")
	public String userLogin(){
		
		return "index";
		
	}
}
