package com.invest.controller;

import com.invest.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {
     private User user;
	@RequestMapping("/user.do")
	public String userLogin(){
		
		return "index";
		
	}
}
