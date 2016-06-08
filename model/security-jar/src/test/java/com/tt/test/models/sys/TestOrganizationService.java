package com.tt.test.models.sys;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;







import com.tt.common.test.SpringTransactionalContextTests;
import com.tt.modules.sys.entity.Organization;
import com.tt.modules.sys.service.OrganizationService;

@ContextConfiguration(locations = {"/spring-context.xml"})
public class TestOrganizationService  extends SpringTransactionalContextTests {
	@Autowired
    private OrganizationService organizationService;
	
	/**
	 * 
	 * //TODO 获取单个机构节点
	 */
	@Test
	public void testget() {
		Organization model = organizationService.get("2");
		Assert.assertEquals("1",model.getParent().getId());
		Assert.assertEquals("root",model.getParent().getName());

	}
	
	@Test
	public void testfindAllList() {
		List<Organization> list = organizationService.findAll();
		Assert.assertEquals(5,list.size());
	}
	@Test
	public void testfindlist() {
		Organization office = new Organization();
		office.setParentIds("1");	
		List<Organization> list = organizationService.findList(office);
		Assert.assertEquals(2,list.size());
	}
	
	//找到父亲子节点
	@Test
	public void testfindbyparentid(){
		Organization office = new Organization();
		office.setParentIds("1");		
		List<Organization> list = organizationService.findByParentId(office);
	    System.out.println(list.size());
	    System.out.println(list.get(0).getName());
	}
	
	//获得所有的子节点
	@Test
	public void testfindbyparentids(){
		Organization office = new Organization();
		office.setParentIds("1");	
		List<Organization> list = organizationService.findbyparentids(office);
	    System.out.println(list.size());
	} 
	@Test
	public void testsave(){
		Organization office = new Organization();
		office.setName("b3");
		office.setType("1");
		office.setSort(30);
		office.setUseable("1");
		office.setGrade("1");
		Organization parent = organizationService.get("5");
        office.setParent(parent);
		organizationService.save(office);
		
	}
	@Test
	public void tesetupdate(){
		Organization office= organizationService.get("5");
		
        office.setName("c");
		organizationService.save(office);
		
		
	}
	
	@Test
	public void testdelete(){
		Organization office= new Organization("5");	
		organizationService.delete(office);
	}
	
	
	
}
