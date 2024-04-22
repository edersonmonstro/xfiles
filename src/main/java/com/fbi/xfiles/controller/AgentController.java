package com.fbi.xfiles.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.domain.dto.AgentDTO;
import com.fbi.xfiles.services.AgentService;
import com.fbi.xfiles.services.DepartmentService;

@Controller
@RequestMapping("/agents")
public class AgentController {

	@Autowired
	AgentService service;

	@Autowired
	DepartmentService departmentService;

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
		model.addAttribute("departments", departmentService.findAll());
		return "/agent/form";
	}

	@PostMapping("/save")
	public String saveObject(Model model, @ModelAttribute("agent") AgentDTO agentDTO, 
		@RequestParam("departmentId") Integer departmentId,
			BindingResult result) {
		
		model.addAttribute("activePage", "menuItemAgents");
		if (result.hasErrors()) {
			System.out.println("agents/save error");
			return "/agent/form";
		}
		Agent a = new Agent();

		a = agentDTO.toAgent();

        Optional<Department> department = departmentService.findById(departmentId);
		if (department.isPresent()) {
			Department dep = department.get();
			// Atribuir o departamento ao agente
			a.setDepartment(dep);
		} else {
			// Lidar com o departamento não encontrado, talvez redirecionar para uma página de erro
			return "redirect:/error";
		}
		service.save(a);
		return "redirect:/agents/";
	}

}