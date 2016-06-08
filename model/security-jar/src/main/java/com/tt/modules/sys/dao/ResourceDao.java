package com.tt.modules.sys.dao;

import java.util.List;

import com.tt.common.dao.CrudDao;
import com.tt.common.persistence.annotation.MyBatisDao;
import com.tt.modules.sys.entity.Resource;

@MyBatisDao
public interface ResourceDao extends CrudDao<Resource>{

	public List<Resource> findByParentIdsLike(Resource menu);

	public List<Resource> findByUserId(Resource menu);
	
	public int updateParentIds(Resource menu);
	
	public int updateSort(Resource menu);

}
