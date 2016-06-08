package com.tt.modules.sys.dao;

import com.tt.common.persistence.annotation.MyBatisDao;
import com.tt.modules.sys.entity.Organization;
import com.tt.common.dao.TreeDao;

/**
 * 机构DAO接口
 */

@MyBatisDao
public interface OrganizationDao extends TreeDao<Organization>{



}
