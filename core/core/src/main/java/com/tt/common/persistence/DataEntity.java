/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tt.common.persistence;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tt.common.utils.IdGen;

/**
 * 数据Entity类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	public DataEntity() {
		super();
	
	}
	
	public DataEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert(){
		
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord){
			setId(IdGen.uuid());
		}
//		User user = UserUtils.getUser();
//		if (StringUtils.isNotBlank(user.getId())){
//			this.updateBy = user;
//			this.createBy = user;
//		}

	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate(){


	}

	/**
	 * @return Returns the delFlag.
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag The delFlag to set.
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	

}
