/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: SysDatacodeController.java 
 * @Prject: core
 * @Package: com.tt.test.web 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2016年5月10日 下午1:59:36 
 * @version: V1.0   
 */
package com.tt.test.web;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tt.common.db.DynamicDataSource;
import com.tt.common.persistence.Page;
import com.tt.common.web.BaseController;
import com.tt.test.service.SysDatacodeService;
import com.tt.test.data.SysDatacode;

/** 
 * @ClassName: SysDatacodeController 
 * @Description: TODO
 * @author: Administrator
 * @date: 2016年5月10日 下午1:59:36  
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysdatacode")
public class SysDatacodeController extends BaseController {
	
	@Autowired
	private SysDatacodeService sysDatacodeService;
	
	@ModelAttribute
	public SysDatacode get(@RequestParam(required=false) String id) {
		DynamicDataSource.setCurrentLookupKey("dataSource2");
		if (id!=null&&!id.equals("")){
			return sysDatacodeService.get(id);
		}else{
			return new SysDatacode();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(SysDatacode SysDatacode, HttpServletRequest request, HttpServletResponse response, Model model) {
		DynamicDataSource.setCurrentLookupKey("dataSource2");
        Page<SysDatacode> page = sysDatacodeService.findPage(new Page<SysDatacode>(request, response), SysDatacode); 
        model.addAttribute("page", page);
		return "modules/sys/sysdatacodeList";
	}	        
	
	@RequestMapping(value = "form")
	public String form(SysDatacode SysDatacode, Model model) {
		model.addAttribute("SysDatacode", SysDatacode);
		return "modules/sys/sysdatacodeForm";
	}
	
	
	@RequestMapping(value = "save")
	public String save(SysDatacode SysDatacode, Model model, RedirectAttributes redirectAttributes) {

//		if (!beanValidator(model, SysDatacode)){
//			return form(SysDatacode, model);
//		}
		DynamicDataSource.setCurrentLookupKey("dataSource");
		sysDatacodeService.save(SysDatacode);
		addMessage(redirectAttributes, "保存字典'" + SysDatacode.getCode() + "'成功");
		return "redirect:" + adminPath + "/sys/sysdatacode/";
	}
	
	@RequestMapping(value = "delete")
	public String delete(SysDatacode SysDatacode, RedirectAttributes redirectAttributes) {
		DynamicDataSource.setCurrentLookupKey("dataSource");
		sysDatacodeService.delete(SysDatacode);
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:" + adminPath + "/sys/sysdatacode/";
	}

	public void setSysDatacodeService(SysDatacodeService sysDatacodeService) {
		this.sysDatacodeService = sysDatacodeService;
	}
	
	
	
}



