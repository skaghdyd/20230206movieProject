package com.study.springboot.hch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.hch.domain.MovieTheaterDTO;
import com.study.springboot.hch.domain.ScreenTheaterDTO;
import com.study.springboot.hch.mapper.MovieTheaterMapper;
import com.study.springboot.hch.mapper.ScreenTheaterMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/screenSchedule")
@RequiredArgsConstructor
public class ScreenScheduleController {

	final MovieTheaterMapper movieTheaterMapper;
	final ScreenTheaterMapper screenTheaterMapper;
	
	
	@GetMapping("/screenScheduleInsertForm")
	public String screenScheduleInsert(Model model) {
		List<MovieTheaterDTO> mTLst = movieTheaterMapper.selectMovieTheaterAll();
		model.addAttribute("mTLst", mTLst);
		return "/hch/screenSchedule/screenScheduleInsertForm";
	}
	
//	수정중
	@GetMapping("/movieNameSend")
	public List<ScreenTheaterDTO> screenTheaterNameList(String movTheaName) {
		List<ScreenTheaterDTO> screenTheaterNameList = screenTheaterMapper.selectCategoryName(movTheaName);
		return screenTheaterNameList;
	}
	

}
