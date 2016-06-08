package com.tt.common.test;

import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tt.common.persistence.Page;
import com.tt.test.data.SysDatacode;
import com.tt.test.service.SysDatacodeService;
@ContextConfiguration(locations = {"/spring-context.xml"})
public class TestSysDatacodeService extends SpringTransactionalContextTests {
	@Autowired
	private SysDatacodeService sysDatacodeService;

	@Test
	public void testsave() {
		SysDatacode model = new SysDatacode();
		model.setCode("sd3434");
		sysDatacodeService.save(model);
	}
	@Test
	public void testget() {
		SysDatacode getModel = new SysDatacode();
		String id = "2";
		getModel = sysDatacodeService.get(id);
		Assert.assertEquals(getModel.getField(), "22");
	}
	@Test
	public void testfindall() {
		List<SysDatacode> list = sysDatacodeService.findList(new SysDatacode());
		Assert.assertTrue(list.size() > 1);
		System.out.println(list.size());
	}
	@Test
	public void testfindpage() {
		Page<SysDatacode> parampage = new Page<SysDatacode>();
		Page<SysDatacode> getpage = sysDatacodeService.findPage(parampage, new SysDatacode());
		System.out.println(getpage.getList().get(0).toString());
		System.out.println(getpage.getTotalPage());
		System.out.println(getpage.getFirstResult());
		System.out.println(getpage.getMaxResults());
		System.out.println(getpage.getCount());
		System.out.println(getpage.toString());
	}
}
