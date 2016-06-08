 
package com.tt.modules.sys.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.tt.common.config.Global;
import com.tt.common.persistence.DataEntity;
import com.tt.common.utils.Collections3;


public class User extends  DataEntity<User> {
	private static final long serialVersionUID = 1L;
	private Organization company;	// 归属公司
	private Organization office;	// 归属部门
	private String loginName;// 登录名
	private String password;// 密码
	private String name;	// 姓名
	private String userType;// 用户类型
	private String useable;	// 是否允许登陆	
	private String remarks;  //备注
	private Role role;	// 根据角色查询用户条件
	
	private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表


	public User() {
		super();
		this.useable = Global.YES;
	}
	
	public User(String id){
		super(id);
	}

	public User(String id, String loginName){
		super(id);
		this.loginName = loginName;
	}

	public User(Role role){
		super();
		this.role = role;
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

	public String getId() {
		return id;
	}


	public Organization getCompany() {
		return company;
	}

	public void setCompany(Organization company) {
		this.company = company;
	}

	public Organization getOffice() {
		return office;
	}

	public void setOffice(Organization office) {
		this.office = office;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@JsonIgnore
	@Length(min=1, max=100, message="密码长度必须介于 1 和 100 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	


	public void setName(String name) {
		this.name = name;
	}




	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks The remarks to set.
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}




	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<String> getRoleIdList() {
		List<String> roleIdList = Lists.newArrayList();
		for (Role role : roleList) {
			roleIdList.add(role.getId());
		}
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		roleList = Lists.newArrayList();
		for (String roleId : roleIdList) {
			Role role = new Role();
			role.setId(roleId);
			roleList.add(role);
		}
	}
	
	/**
	 * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
	 */
	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ",");
	}
	
	public boolean isAdmin(){
		return isAdmin(this.id);
	}
	
	public static boolean isAdmin(String id){
		return id != null && "1".equals(id);
	}
	
	@Override
	public String toString() {
		return id;
	}

	
	
}
