package com.tt.test.models.sys;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tt.common.test.SpringTransactionalContextTests;
import com.tt.modules.sys.entity.User;
import com.tt.modules.sys.service.SystemService;
@ContextConfiguration(locations = {"/spring-context.xml"})
public class TestSystemService extends SpringTransactionalContextTests {
    
	@Autowired
	private SystemService systemService;
	
	
	@Test
	public void testgetUser(){
		   User user = systemService.getUser("1");
		   
	}
	
	
	
	
	
	
}
