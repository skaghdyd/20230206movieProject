package com.study.springboot.hch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.hch.domain.MovieDTO;
import com.study.springboot.hch.domain.MovieTheaterDTO;
import com.study.springboot.hch.mapper.MovieTheaterMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/movieTheater/*")
public class MovieTheaterController {
	
	@Autowired
	private MovieTheaterMapper movieTheaterMapper;

	@GetMapping("/movieTheaterInsertForm")
	public String movieTheaterInsert() {
		return "/hch/movieTheater/movieTheaterInsertForm";
	}
	@PostMapping("/movieTheaterInsert")
	public String movieTheaterInsert(MovieTheaterDTO movieTheaterDTO) {
		int res = movieTheaterMapper.insertMovieTheater(movieTheaterDTO);
		log.info(res + "건 입력");
		return "redirect:/movieTheater/movieTheaterList";
	}
	
	@GetMapping("/movieTheaterList")
	public String movieTheaterList(Model model) {
		List<MovieTheaterDTO> movieTheaterList = movieTheaterMapper.selectMovieTheaterAll();
		
		model.addAttribute("movieTheaterList", movieTheaterList);
		return "/hch/movieTheater/movieTheaterList";
	}
	
	@GetMapping("/movieTheaterDelete")
	public String movieTheaterdelete(int movieTheater_code) {
		int res = movieTheaterMapper.deleteMovieTheater(movieTheater_code);
		log.info(res + "건 삭제");
		
		return "redirect:/movieTheater/movieTheaterList";
	}
	
	@GetMapping("/movieTheaterUpdateForm")
	public String movieTheaterUpdateForm(Model model, int movieTheater_code) {
		List<MovieTheaterDTO> movieTheaterList = movieTheaterMapper.selectMovieTheater(movieTheater_code);
		model.addAttribute("movieTheaterList" ,movieTheaterList);
		
		return "/hch/movieTheater/movieTheaterUpdateForm";
	}
	
	@PostMapping("/movieTheaterUpdate")
	public String movieTheaterUpdate(MovieTheaterDTO movieTheaterDTO) {
		int res = movieTheaterMapper.updateMovieTheater(movieTheaterDTO);
		log.info(res + "건 수정");
		
		return "redirect:/movieTheater/movieTheaterList";
	}
}
