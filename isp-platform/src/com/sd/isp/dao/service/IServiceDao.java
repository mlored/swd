package com.sd.isp.dao.service;

import java.util.List;

import com.sd.isp.dao.base.IBaseDao;
import com.sd.isp.domain.service.ServiceDomain;

public interface IServiceDao extends IBaseDao<ServiceDomain> {
	
	public List<ServiceDomain> findByName(String textToFind);

}
