package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Whisky;
import com.example.demo.service.MWhiskyService;
import com.example.demo.service.WhiskyService;

@Controller
@RequestMapping("/whisky")
public class WhiskyController {
	@Autowired
	private WhiskyService whiskyService;
	
	@Autowired
	private MWhiskyService mWhiskyService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Whisky> whiskyList = whiskyService.whiskyList();
		model.addAttribute("whiskyList", whiskyList);
		return "start";
	}
	
}
