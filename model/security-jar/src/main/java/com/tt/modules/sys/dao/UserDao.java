/*
 * 泰坦公司源代码，版权归泰坦公司所有。
 * 
 * 项目名称 : security-jar
 * 创建日期 : 2016年6月3日
 * 修改历史 : 
 *     1. [2016年6月3日]创建文件 by Administrator
 */
package com.tt.modules.sys.dao;

import java.util.List;

import com.tt.common.dao.CrudDao;
import com.tt.common.persistence.annotation.MyBatisDao;
import com.tt.modules.sys.entity.User;

/**
 * //TODO 添加类/接口功能描述
 * @author Administrator
 */
@MyBatisDao
public interface UserDao extends CrudDao<User>{
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public User getByLoginName(User user);

	/**
	 * 通过OfficeId获取用户列表，仅返回用户id和name（树查询用户时用）
	 * @param user
	 * @return
	 */
	public List<User> findUserByOfficeId(User user);
	
	/**
	 * 查询全部用户数目
	 * @return
	 */
	public long findAllCount(User user);
	
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	public int updatePasswordById(User user);

	/**
	 * 删除用户角色关联数据
	 * @param user
	 * @return
	 */
	public int deleteUserRole(User user);
	
	/**
	 * 插入用户角色关联数据
	 * @param user
	 * @return
	 */
	public int insertUserRole(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUserInfo(User user);

}
