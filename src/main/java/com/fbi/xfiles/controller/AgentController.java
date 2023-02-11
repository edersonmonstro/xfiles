package com.fbi.xfiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fbi.xfiles.services.AgentService;

@Controller
@RequestMapping("/")
public class AgentController {
	
	@Autowired
	AgentService service;
	
	@GetMapping
	public ModelAndView cc() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
		mv.addObject("message", "Welcome Agent X");
		mv.addObject("list", service.findAgentsByDepartment("xfiles"));
		
		return mv;
	}

	@GetMapping("/welcome")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("welcome");
		mv.addObject("message", "Welcome Agent X");
		
		return mv;
	}
	
}