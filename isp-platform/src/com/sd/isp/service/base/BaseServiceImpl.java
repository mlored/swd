package com.sd.isp.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, RESULT extends BaseResult<DTO>> implements IBaseService<DTO, DOMAIN, DAO, RESULT> {

	protected static final String CACHE_REGION = "isp-platform-cache";
	@Autowired
	private CacheManager cacheManager;

	protected CacheManager getCacheManager() {
		return cacheManager;
	}
	
	public abstract DTO convertDomainToDto(DOMAIN domain);

	public abstract DOMAIN convertDtoToDomain(DTO dto);

}
