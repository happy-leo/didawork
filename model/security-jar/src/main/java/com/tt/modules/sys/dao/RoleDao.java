/*
 * 泰坦公司源代码，版权归泰坦公司所有。
 * 
 * 项目名称 : security-jar
 * 创建日期 : 2016年6月3日
 * 修改历史 : 
 *     1. [2016年6月3日]创建文件 by Administrator
 */
package com.tt.modules.sys.dao;

import com.tt.common.dao.CrudDao;
import com.tt.common.persistence.annotation.MyBatisDao;
import com.tt.modules.sys.entity.Role;

/**
 * //TODO 添加类/接口功能描述
 * @author Administrator
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role>{
	
	
	public Role getByName(Role role);
	
	public Role getByEnname(Role role);

	/**
	 * 维护角色与菜单权限关系
	 * @param role
	 * @return
	 */
	public int deleteRoleResource(Role role);

	public int insertRoleResource(Role role);
	
	/**
	 * 维护角色与公司部门关系
	 * @param role
	 * @return
	 */
	public int deleteRoleOrganization(Role role);

	public int insertRoleOrganization(Role role);

}
