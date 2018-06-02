package com.sd.isp.rest.service;

import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IServiceResource extends IBaseResource<ServiceDTO, ServiceResult>{
    public ServiceResult getAll();
}
