/*
 * 泰坦公司源代码，版权归泰坦公司所有。
 * 
 * 项目名称 : security-jar
 * 创建日期 : 2016年6月3日
 * 修改历史 : 
 *     1. [2016年6月3日]创建文件 by Administrator
 */
package com.tt.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.common.service.TreeService;
import com.tt.modules.sys.dao.OrganizationDao;
import com.tt.modules.sys.entity.Organization;
import com.tt.modules.sys.util.UserUtils;
import com.tt.test.data.SysDatacode;

/**
 * //TODO 添加类/接口功能描述
 * @author Administrator
 */
@Service(value="organizationService")
@Transactional(readOnly = true)
public class OrganizationService extends TreeService<OrganizationDao,Organization>{

	
	@Transactional(readOnly = true)
	public Organization get(String id) {
		Organization organization = super.get(id);
		return organization;
	}
	
	/**
	 * 
	 * //TODO 获取所有的机构
	 * @return 机构的集合
	 */
	@Transactional(readOnly = true)
	public List<Organization> findAll(){
		return  dao.findAllList(new Organization());

	}
	
	@Transactional(readOnly = true)
	public List<Organization> findList(Organization office){
		return  dao.findList(office);
	}
	
	
	@Transactional(readOnly = true)
	public List<Organization> findbyparentids(Organization office){
		office.setParentIds(office.getParentIds()+"%");
		return dao.findByParentIdsLike(office);
	}
	
	
	@Transactional(readOnly = true)
	public List<Organization> findByParentId(Organization office){
		return dao.findByParentId(office);
	}
	
	
	@Transactional(readOnly = false)
	public void save(Organization office) {
		super.save(office);
//		UserUtils.removeCache(UserUtils.CACHE_ORGANIZATION_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Organization office) {
		super.delete(office);
//		UserUtils.removeCache(UserUtils.CACHE_ORGANIZATION_LIST);
	}
	

}
