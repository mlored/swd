package com.sd.isp.service.support;

import com.sd.isp.dao.support.SupportDaoImpl;
import com.sd.isp.domain.support.SupportDomain;
import com.sd.isp.dto.support.SupportDTO;
import com.sd.isp.dto.support.SupportResult;
import com.sd.isp.service.base.IBaseService;

public interface ISupportService extends IBaseService<SupportDTO, SupportDomain, SupportDaoImpl, SupportResult>{
	
}