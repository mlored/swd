package com.sd.isp.service.base;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.base.BaseResult;

public interface IBaseService<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);

	public DTO getById(Integer id);

	public R getAll();
	
	public DTO updateById(Integer id, DTO dto);

	public DTO delete(Integer id);
	
	public R find(String textToFind, int page, int maxItems) throws Exception;

}
