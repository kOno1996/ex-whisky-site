package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class UserRegisterController {
	@RequestMapping("/profile")
	public String profile(Model model) {
		Map<Integer, String> areas = new LinkedHashMap<Integer, String>();
		areas.put(1, "北海道");areas.put(2, "青森県");areas.put(3, "岩手県");
		areas.put(4, "宮城県");areas.put(5, "秋田県");areas.put(6, "山形県");
		areas.put(7, "福島県");areas.put(8, "茨城県");areas.put(9, "栃木県");
		areas.put(10, "群馬県");areas.put(11, "埼玉県");areas.put(12, "千葉県");
		areas.put(13, "東京都");areas.put(14, "神奈川県");areas.put(15, "新潟県");
		areas.put(16, "富山県");areas.put(17, "石川県");areas.put(18, "福井県");
		areas.put(19, "山梨県");areas.put(20, "長野県");areas.put(21, "岐阜県");
		areas.put(22, "静岡県");areas.put(23, "愛知県");areas.put(24, "三重県");
		areas.put(25, "滋賀県");areas.put(26, "京都府");areas.put(27, "大阪府");
		areas.put(28, "兵庫県");areas.put(29, "奈良県");areas.put(30, "和歌山県");
		areas.put(31, "鳥取県");areas.put(32, "島根県");areas.put(33, "岡山県");
		areas.put(34, "広島県");areas.put(35, "山口県");areas.put(36, "徳島県");
		areas.put(37, "香川県");areas.put(38, "愛媛県");areas.put(39, "高知県");
		areas.put(40, "福岡県");areas.put(41, "佐賀県");areas.put(42, "長崎県");
		areas.put(43, "熊本県");areas.put(44, "大分県");areas.put(45, "宮崎県");
		areas.put(46, "鹿児島県");areas.put(47, "沖縄県");
		
		model.addAttribute("areas", areas);
		return "register";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "start";
	}
	
}
