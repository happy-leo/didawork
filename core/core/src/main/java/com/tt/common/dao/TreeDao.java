/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tt.common.dao;

import java.util.List;

import com.tt.common.persistence.TreeEntity;

/**
 * DAO支持类实现
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public interface TreeDao<T extends TreeEntity<T>> extends CrudDao<T> {

	/**
	 * 找到所有子节点
	 * @param entity
	 * @return
	 */
	public List<T> findByParentIdsLike(T entity);

	/**
	 * 更新所有父节点字段
	 * @param entity
	 * @return
	 */
	public int updateParentIds(T entity);
	

	/**
	 * 找到节点的第一层子节点
	 * @param entity
	 * @return
	 */
	public List<T> findByParentId(T entity);

}