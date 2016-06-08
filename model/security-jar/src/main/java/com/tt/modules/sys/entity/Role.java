/*
 * 泰坦公司源代码，版权归泰坦公司所有。
 * 
 * 项目名称 : security-jar
 * 创建日期 : 2016年6月2日
 * 修改历史 : 
 *     1. [2016年6月2日]创建文件 by Administrator
 */
package com.tt.modules.sys.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.tt.common.config.Global;
import com.tt.common.persistence.DataEntity;

/**
 * //TODO 添加类/接口功能描述
 * 
 * @author Administrator
 */
public class Role extends DataEntity<Role> {

	private static final long serialVersionUID = 1L;
	private Organization office; // 归属机构
	private String name; // 角色名称
	private String enname; // 英文名称
	private String roleType;// 权限类型
	private String useable; // 是否是可用
	private User user; // 根据用户ID查询角色列表
	private List<Resource> menuList = Lists.newArrayList(); // 拥有菜单列表

	public Role() {
		super();
		this.useable = Global.YES;
	}

	public Role(String id) {
		super(id);
	}

	public Role(User user) {
		this();
		this.user = user;
	}

	public Organization getOffice() {
		return office;
	}

	public void setOffice(Organization office) {
		this.office = office;
	}

	@Length(min = 1, max = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 1, max = 100)
	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	@Length(min = 1, max = 100)
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	
	
	
	/**
	 * @return Returns the useable.
	 */
	public String getUseable() {
		return useable;
	}

	/**
	 * @param useable The useable to set.
	 */
	public void setUseable(String useable) {
		this.useable = useable;
	}

	public List<Resource> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Resource> menuList) {
		this.menuList = menuList;
	}

	public List<String> getMenuIdList() {
		List<String> menuIdList = Lists.newArrayList();
		for (Resource menu : menuList) {
			menuIdList.add(menu.getId());
		}
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		menuList = Lists.newArrayList();
		for (String menuId : menuIdList) {
			Resource menu = new Resource();
			menu.setId(menuId);
			menuList.add(menu);
		}
	}

	public String getMenuIds() {
		return StringUtils.join(getMenuIdList(), ",");
	}

	public void setMenuIds(String menuIds) {
		menuList = Lists.newArrayList();
		if (menuIds != null) {
			String[] ids = StringUtils.split(menuIds, ",");
			setMenuIdList(Lists.newArrayList(ids));
		}
	}

	/**
	 * 获取权限字符串列表
	 */
	public List<String> getPermissions() {
		List<String> permissions = Lists.newArrayList();
		for (Resource menu : menuList) {
			if (menu.getPermission() != null
					&& !"".equals(menu.getPermission())) {
				permissions.add(menu.getPermission());
			}
		}
		return permissions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
