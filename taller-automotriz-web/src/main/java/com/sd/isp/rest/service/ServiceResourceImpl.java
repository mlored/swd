package com.sd.isp.rest.service;

import org.springframework.stereotype.Repository;
import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("serviceResource")
public class ServiceResourceImpl extends BaseResourceImpl<ServiceDTO, ServiceResult> implements IServiceResource {

    public ServiceResourceImpl() {
        super(ServiceDTO.class, "/service", ServiceResult.class);
    }

    @Override
    public ServiceResult getAll() {
        return super.getAll();
    }

    @Override
    public ServiceResult find(String textToFind, int maxItems, int page) {
        //setWebResourceBasicAuthFilter();
        final ServiceResult result = findWR(textToFind, maxItems, page);
        return result;
    }

}
