/*
 * 泰坦公司源代码，版权归泰坦公司所有。
 * 
 * 项目名称 : security-jar
 * 创建日期 : 2016年6月2日
 * 修改历史 : 
 *     1. [2016年6月2日]创建文件 by Administrator
 */
package com.tt.modules.sys.entity;


import com.tt.common.persistence.TreeEntity;

/**
 * //TODO 添加类/接口功能描述
 * @author Administrator
 */
public class Organization extends TreeEntity<Organization>{


	private static long serialVersionUID = 1L;
	private String type; 	// 机构类型（1：公司；2：部门；3：小组）
	private String grade; 	// 机构等级（1：一级；2：二级；3：三级；4：四级）
	private String useable;//是否可用
	private String remarks;//备注
	
	public Organization(){
		super();
		//this.type="";
	}
	
	public Organization(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Organization getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
	@Override
	public void setParent(Organization parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
	}



	/**
	 * @return Returns the remarks.
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks The remarks to set.
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the grade.
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade The grade to set.
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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


	
	
	

}
