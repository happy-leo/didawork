package com.tt.test.models.sys;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tt.common.test.SpringTransactionalContextTests;
import com.tt.modules.sys.dao.ResourceDao;
import com.tt.modules.sys.dao.RoleDao;
import com.tt.modules.sys.dao.UserDao;
import com.tt.modules.sys.entity.User;
import com.tt.modules.sys.shiro.session.SessionDAO;



@ContextConfiguration(locations = {"/spring-context.xml"})
public class TestSystemDao extends SpringTransactionalContextTests {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ResourceDao resourceDao;

	//获取当个用户信息
	@Test
	public void testgetUser(){
		   User user = userDao.get("1");
		   System.out.println(user.getName());
	}
	
	//通过登录账户获取用户
    @Test
    public void testgetByLoginName(){
           User user = userDao.getByLoginName(new User(null,"admin"));
           System.out.println(user.getName());    	 
    }

    @Test
    public void testgetList(){
    	   List<User> list = userDao.findList(new User());
    }
}
