package com.sd.isp.dao.base;

import java.util.List;

import com.sd.isp.domain.base.BaseDomain;

public interface IBaseDao<DOMAIN extends BaseDomain> {

	public DOMAIN save(DOMAIN domain);

	public DOMAIN getById(Integer domainId);

	public abstract List<DOMAIN>find(String textToFind, int page, int maxItems) throws Exception;

	public List<DOMAIN> findAll();
	
	public DOMAIN updateById(Integer domainId, DOMAIN domain);
	
	public DOMAIN delete(Integer domainId);
}
