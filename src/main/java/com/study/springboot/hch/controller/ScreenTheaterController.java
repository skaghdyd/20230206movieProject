package com.study.springboot.hch.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.hch.domain.MovieTheaterDTO;
import com.study.springboot.hch.domain.ScreenTheaterDTO;
import com.study.springboot.hch.mapper.MovieTheaterMapper;
import com.study.springboot.hch.mapper.ScreenTheaterMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/screenTheater/*")
public class ScreenTheaterController {
	
	@Autowired
	private MovieTheaterMapper movieTheaterMapper;
	@Autowired
	private ScreenTheaterMapper screenTheaterMapper;

	@GetMapping("/screenTheaterInsertForm")
	public String screenTheaterInsert(Model model) {
		List<MovieTheaterDTO> movieTherter = movieTheaterMapper.selectMovieTheaterAll();
		model.addAttribute("movieTheaterLst", movieTherter);
		return "/hch/screenTheater/screenTheaterInsertForm";
	}
	
	@PostMapping("/screenTheaterInsert")
	public String screenTheaterInsert(ScreenTheaterDTO screenTheaterDTO) {
		int res = screenTheaterMapper.insertScreenTheater(screenTheaterDTO);
		log.info("--상영관 " + res + "건 입력했습니다.");
		return "redirect:/screenTheater/screenTheaterList";
	}
	
	@GetMapping("/screenTheaterList")
	public String screenTheaterList(Model model) {
		List<HashMap> slst = screenTheaterMapper.selectScreenTheaterAll();
		model.addAttribute("screenTheaterList", slst);
		return "/hch/screenTheater/screenTheaterList";
	}
	
	@GetMapping("/screenTheaterDelete")
	public String screenTheaterDelete(int screenTheater_code) {
		int res = screenTheaterMapper.deleteScreenTheater(screenTheater_code);
		log.info("상영관 " + res + "건 삭제");
		return "redirect:/screenTheater/screenTheaterList";
	}
	
	
}
