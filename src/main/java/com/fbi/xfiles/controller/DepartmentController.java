package com.fbi.xfiles.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.domain.dto.DepartmentDTO;
import com.fbi.xfiles.services.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	Department department;
	
	@GetMapping("")
	public ModelAndView index(Model model) {
		model.addAttribute("activePage", "menuItemDepartments");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/department/list");
		mv.addObject("list", service.findAll());
		return mv;
	}
	
	@GetMapping("/new")
	public String frmCreate(Model model, @ModelAttribute("department") DepartmentDTO department) {
		model.addAttribute("activePage", "menuItemDepartments");
		return "/department/form";
	}

	/**
	 * Save Method. Works both for new and edit
	 * @param model
	 * @param departmentDTO
	 * @param result
	 * @return a department saved and user redirected to list screen
	 */
	@PostMapping("/save")
	public String saveObject(Model model, @ModelAttribute("department") DepartmentDTO departmentDTO, BindingResult result) {
		model.addAttribute("activePage", "menuItemDepartments");
		if (result.hasErrors()) {
			return "/department/form";
		}
		Department s = new Department();
		s = departmentDTO.toDepartment();
		s.setCreationDate(new Date());
		service.save(s);
		return "redirect:/departments/";
	}

	@GetMapping("/setupEdit/{id}")
	public String setupEdit(@PathVariable("id") Integer id, Model model) {
		Department department = service.getOne(id);
		model.addAttribute("department", department);
		return "/department/form";
	}
	
}