package com.sd.isp.rest.base;

import com.sd.isp.dto.base.BaseDTO;

public interface IBaseResource<DTO extends BaseDTO> {

	public DTO save(DTO dto);

	public DTO getById(Integer id);

}
