package com.sd.isp.service.base;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, RESULT extends BaseResult<DTO>> implements IBaseService<DTO, DOMAIN, DAO, RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}
