package com.study.springboot.hch.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.hch.domain.MovieDTO;
import com.study.springboot.hch.domain.MovieTheaterDTO;
import com.study.springboot.hch.domain.ScreenScheduleDTO;
import com.study.springboot.hch.domain.ScreenTheaterDTO;
import com.study.springboot.hch.mapper.MovieMapper;
import com.study.springboot.hch.mapper.MovieTheaterMapper;
import com.study.springboot.hch.mapper.ScreenScheduleMapper;
import com.study.springboot.hch.mapper.ScreenTheaterMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/screenSchedule/*")
@RequiredArgsConstructor
public class ScreenScheduleController {

	final private MovieMapper movieMapper;
	final private MovieTheaterMapper movieTheaterMapper;
	final private ScreenTheaterMapper screenTheaterMapper;
	final private ScreenScheduleMapper screenScheduleMapper;
	
	
	@GetMapping("/screenScheduleInsertForm")
	public String screenScheduleInsertForm(Model model) {
		List<MovieDTO> mLst = movieMapper.selectMovieAll();
		List<MovieTheaterDTO> mTLst = movieTheaterMapper.selectMovieTheaterAll();
		model.addAttribute("mTLst", mTLst);
		model.addAttribute("mLst", mLst);
		return "/hch/screenSchedule/screenScheduleInsertForm";
	}
	
//	ajax 통신 부분
	@PostMapping("/movieNameSend")
	@ResponseBody
	public List<ScreenTheaterDTO> screenTheaterNameList(
			@RequestParam("selecName") String selecName) {
		List<ScreenTheaterDTO> screenTheaterNameList = screenTheaterMapper.selectCategoryName(selecName);
		
		System.out.println("ajax요청 도착 : " + selecName);
		return screenTheaterNameList;
	}
	
	@PostMapping("/screenScheduleInsert")
	public String screenScheduleInsert(ScreenScheduleDTO screenScheduleDTO) {
		screenScheduleMapper.insertScreenSchedule(screenScheduleDTO);

		return "/hch/screenSchedule/screenScheduleList";
	}
	
	@GetMapping("/screenScheduleList")
	public String screenScheduleList(Model model) {
		List<HashMap> screScheLst = screenScheduleMapper.findscreenScheduleAll();
		model.addAttribute("screScheLst", screScheLst);
		return "/hch/screenSchedule/screenScheduleList";
	}
	

}
