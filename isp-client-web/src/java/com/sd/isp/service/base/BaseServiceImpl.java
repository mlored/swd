package com.sd.isp.service.base;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.dto.base.BaseDTO;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}

	protected abstract BEAN convertDtoToBean(DTO dto);

	protected abstract DTO convertBeanToDto(BEAN bean);

}
