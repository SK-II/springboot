package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.result.ResponseResult;
import com.example.utils.JsonUtils;

@Controller
@RequestMapping("/err")
public class ErrorController {

	@GetMapping("/error")
	public String error() {
		int i = 1 / 0;
		return "";
	}
	
	
	@PostMapping("/ajax/error")
	@ResponseBody
	public String ajaxError() {
		int i = 1 / 0;
		return JsonUtils.objectToJson(ResponseResult.resultSuccess());
	}
	
	
}
