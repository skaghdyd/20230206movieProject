package com.study.springboot.hch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/screenTheater")
public class ScreenTheaterController {

	@GetMapping("/screenTheaterInsertForm")
	public String screenTheaterInsert() {
		return "/hch/screenTheater/screenTheaterInsertForm";
	}
}
