package com.fbi.xfiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.domain.dto.AgentDTO;
import com.fbi.xfiles.services.AgentService;

@Controller
@RequestMapping("/agents")
public class AgentController {

	@Autowired
	AgentService service;

	Department object;

	@GetMapping("")
	public ModelAndView index(Model model) {
		model.addAttribute("activePage", "menuItemAgents");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/agent/list");
		mv.addObject("list", service.findAll());
		return mv;
	}

	@GetMapping("/new")
	public String frmCreate(Model model, @ModelAttribute("agent") AgentDTO agent) {
		model.addAttribute("activePage", "menuItemAgents");
		return "/agent/form";
	}

	@PostMapping("/save")
	public String saveObject(Model model, @ModelAttribute("agent") AgentDTO agentDTO,
			BindingResult result) {
		
		model.addAttribute("activePage", "menuItemAgents");
		if (result.hasErrors()) {
			System.out.println("agents/save error");
			return "/agent/form";
		}
		Agent a = new Agent();
		System.out.println(agentDTO.getBirthDate());
		a = agentDTO.toAgent();
		service.save(a);
		return "redirect:/agents/";
	}

}