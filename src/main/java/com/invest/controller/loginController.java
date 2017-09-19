package com.invest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invest.pojo.User;

@Controller
@RequestMapping("/login")
public class loginController {
     private User user;
	@RequestMapping("/user.do")
	public String userLogin(){
		
		return "index";
		
	}
}
