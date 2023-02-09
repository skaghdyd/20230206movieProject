package com.study.springboot.hch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.hch.domain.MovieDTO;
import com.study.springboot.hch.mapper.MovieMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/movie")
public class MovieController {

	private MovieMapper movieMapper;
	
	@GetMapping("/movieInsertForm")
	public String movieInsertForm() {
		return "/hch/movie/movieInsertForm";
	}
	
	@PostMapping("/movieInsert")
	public String movieInsert(MovieDTO movieDTO) {
		int res = movieMapper.insertMovie(movieDTO);
		System.out.println(res);
		return "/hch/movie/movieInsertResult";
	}
	
	@GetMapping("/movieInsertResult")
	public String movieInsertResult() {
		return "/hch/movie/movieInsertResult";
	}
}
