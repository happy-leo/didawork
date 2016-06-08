/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: DemoController.java 
 * @Prject: admin-web
 * @Package: com.tt.demo 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2016年5月31日 上午10:12:15 
 * @version: V1.0   
 */
package com.tt.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName: DemoController 
 * @Description: TODO
 * @author: Administrator
 * @date: 2016年5月31日 上午10:12:15  
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	
	@RequestMapping(value = "list")
	public String list(){
		
		return "modules/demo/demolist";
	}
}
