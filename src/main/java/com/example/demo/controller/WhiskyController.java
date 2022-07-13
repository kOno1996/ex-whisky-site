package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/whisky")
public class WhiskyController {
	@RequestMapping("")
	public String index() {
		return "start";
	}
}
