package com.study.springboot.jnr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.jnr.domain.HelpDTO;
import com.study.springboot.jnr.mapper.HelpMapper;

import groovyjarjarpicocli.CommandLine.Help;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/help/*")
public class HelpController {
	
	@Autowired
	private HelpMapper helpMapper;
	
	
	//도움말목록 페이지 
	@GetMapping("/helpList")
	public String helpList(Model model) {
		List<HelpDTO> helpList = helpMapper.selectHelpAll();
				
		
		model.addAttribute("helpList", helpList);
		return "jnr/help/helpList";
	}
	
	//글작성 페이지 
	@GetMapping("/helpInsertForm") 
	public String helpInsertForm() {
		return "/jnr/help/helpInsertForm";
	}
	
	//글 작성 
	@PostMapping("/helpInsert")
	public String helpInsert(HelpDTO helpDTO) { 
		int result = helpMapper.insertHelp(helpDTO);
		log.info(result + "작성 완료");
		return "redirect:/help/helpList";		
	}
	
	//글 삭제
	@GetMapping("/helpDelete") 
	public String delete(int help_id) {
		int result = helpMapper.deleteHelp(help_id);
		log.info(result + "삭제 완료");
		
		return "redirect:/help/helpList";
	}
	
	//글 수정페이지 
	@GetMapping("/helpUpdateForm")
	public String helpUpdateForm(Model model, int help_id) {
		List<HelpDTO> helpList = helpMapper.selectHelp(help_id);
		model.addAttribute("helpList", helpList);
		
		return "/jnr/help/helpUpdateForm";
	}
	
	//글 수정 
	@PostMapping("/helpUpdate")
	public String helpUpdate(HelpDTO helpDTO) {
		int result = helpMapper.updateMovie(helpDTO);
		log.info(result + "수정 완료");
		
		return "redirect:/help/helpList";
	}
	
	//글 검색
	@GetMapping("/helpSearch")
	public String helpSearch(Model model, String helpSearch, String type) {
		List<HelpDTO> helpList = helpMapper.findAllHelp(helpSearch, type);
		model.addAttribute("helpList", helpList);
		return "/jnr/help/helpList";
	}
	
}

