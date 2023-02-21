package com.study.springboot.lby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springboot.lby.domain.EventDTO;
import com.study.springboot.lby.mapper.EventMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping(method = RequestMethod.POST)
public class AddEventController {
	@Autowired
	private EventMapper eventMapper;
	
	@GetMapping("/eventAdd")
	public String eventInsert() {
		return "/lby/eventAdd";
	}
	@PostMapping("/eventInsert")
	public String eventInsert(EventDTO eventDTO) {
		int res = eventMapper.insertEvent(eventDTO);
		log.info(res+"건 입력");
		return"redirect:/eventList";
	}		
//	@GetMapping("/eventList")
//	public String eventList(Model model) {
//		List<EventDTO> eventList = eventMapper.selectEventAll();
//		model.addAttribute("eventList", eventList);
//		return"/lby/eventList";
//	}
	
}
