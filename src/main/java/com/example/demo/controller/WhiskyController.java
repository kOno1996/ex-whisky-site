package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.MWhisky;
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
	public String index(Model model) throws IOException{
		List<Whisky> whiskyList = whiskyService.whiskyList();
		model.addAttribute("whiskyList", whiskyList);
		return "start";
	}
	
	@GetMapping("/detail/{id}")
	public String getWhisky(@PathVariable("id") Integer id, Model model) {
		MWhisky whisky = mWhiskyService.getWhisky(id);
		model.addAttribute("whisky", whisky);
		return "whisky-detail";
	}
	
	@RequestMapping("/ways/highball")
	public String highball() {
		return "whisky-highball";
	}
}
