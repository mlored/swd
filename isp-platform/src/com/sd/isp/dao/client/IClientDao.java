package com.sd.isp.dao.client;

import java.util.List;

import com.sd.isp.dao.base.IBaseDao;
import com.sd.isp.domain.client.ClientDomain;

public interface IClientDao extends IBaseDao<ClientDomain> {

	public List<ClientDomain> findByName(String textToFind);

}
