package com.invest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {

	@RequestMapping("/user.do")
	public String userLogin(){
		
		return "index";
		
	}
}
