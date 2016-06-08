package com.tt.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.common.persistence.Page;
import com.tt.common.service.CrudService;
import com.tt.test.dao.SysDatacodeDao;
import com.tt.test.data.SysDatacode;



@Service(value="sysDatacodeService")
@Transactional(readOnly = true)
public class SysDatacodeService  extends CrudService<SysDatacodeDao, SysDatacode> {


	
	public SysDatacode get(String id) {
		SysDatacode SysDatacode = super.get(id);
		return SysDatacode;
	}
	
	public List<SysDatacode> findList(SysDatacode SysDatacode) {
		return super.findList(SysDatacode);
	}
	
	public Page<SysDatacode> findPage(Page<SysDatacode> page, SysDatacode SysDatacode) {
		return super.findPage(page, SysDatacode);
	}
	
	@Transactional(readOnly = false)
	public void save(SysDatacode SysDatacode) {
		super.save(SysDatacode);
}
	
	@Transactional(readOnly = false)
	public void delete(SysDatacode SysDatacode) {
		super.delete(SysDatacode);
	}


	
}
