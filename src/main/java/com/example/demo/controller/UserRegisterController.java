package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class UserRegisterController {
	@RequestMapping("/profile")
	public String profile() {
		return "register";
	}
}
