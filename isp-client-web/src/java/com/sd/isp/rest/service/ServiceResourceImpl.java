package com.sd.isp.rest.service;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("serviceResource")
public class ServiceResourceImpl extends BaseResourceImpl<ServiceDTO> implements IServiceResource {

    public ServiceResourceImpl() {
        super(ServiceDTO.class, "/service");
    }

    @Override
    public ServiceResult getAll() {
        final ServiceResult result = getWebResource().get(ServiceResult.class);
        return result;
    }

}
