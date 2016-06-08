package com.tt.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	
	@RequestMapping(value = "index")
	public String index(){
		
		return "modules/index/index";
	}

}
