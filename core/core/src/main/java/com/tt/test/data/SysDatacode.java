/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: SysDatacode.java 
 * @Prject: core
 * @Package: com.tt.common.test.data 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2016年5月5日 上午9:40:37 
 * @version: V1.0   
 */
package com.tt.test.data;
import javax.xml.bind.annotation.XmlAttribute;

import org.hibernate.validator.constraints.Length;

import com.tt.common.persistence.BaseEntity;
import com.tt.common.persistence.DataEntity;

/** 
 * @ClassName: SysDatacode 
 * @Description: TODO
 * @author: Administrator
 * @date: 2016年5月5日 上午9:40:37  
 */
public class SysDatacode extends  DataEntity<SysDatacode> {


	public SysDatacode(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public SysDatacode() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	
	//字段
	private String field;
	//字段说明
	private String fieldname;
	//编码
	private String code;
	//编码描述
	private String codedesc;
	//是否可以启动
	private String enabled;
	//是否可以编辑
	private String editmodel;
	//排序
	private int sortno;
	//备注
	private String remark;
	
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	@XmlAttribute
	@Length(min=1, max=100)
	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	@XmlAttribute
	@Length(min=1, max=100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@XmlAttribute
	@Length(min=1, max=100)
	public String getCodedesc() {
		return codedesc;
	}

	public void setCodedesc(String codedesc) {
		this.codedesc = codedesc;
	}
	@XmlAttribute
	@Length(min=1, max=100)
	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	
	public String getEditmodel() {
		return editmodel;
	}

	public void setEditmodel(String editmodel) {
		this.editmodel = editmodel;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}
	@XmlAttribute
	@Length(min=1, max=100)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
