package com.sd.isp.service.service;

import com.sd.isp.dao.service.ServiceDaoImpl;
import com.sd.isp.domain.service.ServiceDomain;
import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.service.base.IBaseService;

public interface IServiceService extends IBaseService<ServiceDTO, ServiceDomain, ServiceDaoImpl, ServiceResult> {

}

