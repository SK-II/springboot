package com.example.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	/**
	 *********************************************************.<br>
	 * [方法] index <br>
	 * [描述] TODO(方法作用) <br>
	 * [参数] TODO(对参数的描述) @param modelMap
	 * [参数] TODO(对参数的描述) @return <br>
	 * [返回] String <br>
	 * [时间] 2019年5月5日 上午10:02:21 <br>
	 * [作者] 杨帅良 【ysl】
	 *********************************************************.<br>
	 */
	@GetMapping("/index")
	public String index(ModelMap modelMap) {
		return "thymeleaf/index";
	}

}
