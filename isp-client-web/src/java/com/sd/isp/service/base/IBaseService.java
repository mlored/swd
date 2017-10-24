package com.sd.isp.service.base;

import java.util.List;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.dto.base.BaseDTO;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {
	public BEAN save(BEAN bean);

	public List<BEAN> getAll();

	public BEAN getById(Integer id);
}
