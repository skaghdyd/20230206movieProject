package com.study.springboot.hch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.hch.domain.MovieTheaterDTO;
import com.study.springboot.hch.mapper.MovieTheaterMapper;
import com.study.springboot.hch.mapper.ScreenTheaterMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/screenTheater")
public class ScreenTheaterController {
	
	@Autowired
	private MovieTheaterMapper movieTheaterMapper;
	@Autowired
	private ScreenTheaterMapper screenTheaterMapper;

	@GetMapping("/screenTheaterInsertForm")
	public String screenTheaterInsert(Model model) {
		List<MovieTheaterDTO> movieTherter = movieTheaterMapper.selectMovieTheaterNames();
		model.addAttribute("movieTheaterName", movieTherter);
		return "/hch/screenTheater/screenTheaterInsertForm";
	}
	
	
}
