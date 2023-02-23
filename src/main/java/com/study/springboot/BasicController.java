package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "인덱스페이지");
		return "index";
	}
}
