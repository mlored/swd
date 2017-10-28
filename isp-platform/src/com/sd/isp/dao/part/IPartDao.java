package com.sd.isp.dao.part;

import java.util.List;

import com.sd.isp.dao.base.IBaseDao;
import com.sd.isp.domain.part.PartDomain;

public interface IPartDao extends IBaseDao<PartDomain> {
	
	public List<PartDomain> findByName(String textToFind);

}
