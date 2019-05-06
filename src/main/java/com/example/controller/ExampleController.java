package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pojo.Resource;

@Controller
public class ExampleController {
	
	@Autowired
	private Resource resource;
	
	@GetMapping("/source")
	public void source() {
		System.out.println(resource);
	}
	
	
	@GetMapping("/freemarker")
	public String freemarker(ModelMap modelMap) {
		// ModelMap 相当于ModelAndView
		modelMap.addAttribute("resource", resource);
		return "freemarker/index";
	}
	
	
	@GetMapping("/thymeleaf")	
	public String thymeleaf(ModelMap modelMap) {
		// ModelMap 相当于ModelAndView
		modelMap.addAttribute("resource", resource);
		return "thymeleaf/index";
	}
	
	
}
