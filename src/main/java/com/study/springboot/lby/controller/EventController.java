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
public class EventController {
	@Autowired
	private EventMapper eventMapper;

	@GetMapping("/eventForm")
	public String selectevent(Model mm) {
		 List<EventDTO> eventList = eventMapper.selectEventAll();
		 mm.addAttribute("eventList", eventList);
		 return "/lby/eventForm";
	}

	@GetMapping("/eventList")
	public String selecteventList(Model model) {
		List<EventDTO> eventList = eventMapper.selectEventAll();
		model.addAttribute("eventList", eventList);
		return "/lby/eventList";

	}
	
	@GetMapping("/search")
		public String search(Model model,String search,String type) {
		List<EventDTO> eventList=eventMapper.findAllEventDTO(search, type);
		model.addAttribute("eventList",eventList);
		return "/lby/eventList";
	}
	
}



