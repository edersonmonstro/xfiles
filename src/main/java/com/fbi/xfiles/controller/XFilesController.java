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
@RequestMapping("/")
public class XFilesController {

	@Autowired
	AgentService service;

	Department object;

	@GetMapping("/")
	public String frmCreate() {
		return "/index";
	}

}