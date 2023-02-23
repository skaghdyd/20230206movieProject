package com.study.springboot.hch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.hch.domain.MovieDTO;
import com.study.springboot.hch.mapper.MovieMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/movie/*")
public class MovieController {

	@Autowired
	private MovieMapper movieMapper;
	
	@GetMapping("/index")
	public String indexPage() {
		return "/hch/index_movie";
	}
	
	@GetMapping("/movieInsertForm")
	public String movieInsertForm() {
		return "/hch/movie/movieInsertForm";
	}
	
	@PostMapping("/movieInsert")
	public String movieInsert(MovieDTO movieDTO) {
		int res = movieMapper.insertMovie(movieDTO);
		log.info(res + "건 입력");
		return "redirect:/movie/movieList";
	}
	
	@GetMapping("/movieList")
	public String movieList(Model model) {
		List<MovieDTO> movieList = movieMapper.selectMovieAll();
		
		model.addAttribute("movieList", movieList);
		return "/hch/movie/movieList";
	}
	
	@GetMapping("/movieDelete")
	public String delete(int movie_code) {
		int res = movieMapper.deleteMovie(movie_code);
		log.info(res + "건 삭제");
		
		return "redirect:/movie/movieList";
	}
	
	@GetMapping("/movieUpdateForm")
	public String movieUpdateForm(Model model, int movie_code) {
		List<MovieDTO> movieList = movieMapper.selectMovie(movie_code);
		model.addAttribute("movieList" ,movieList);
		
		return "/hch/movie/movieUpdateForm";
	}
	
	@PostMapping("/movieUpdate")
	public String movieUpdate(MovieDTO movieDTO) {
		int res = movieMapper.updateMovie(movieDTO);
		log.info(res + "건 수정");
		
		return "redirect:/movie/movieList";
	}
}
