package com.sd.isp.rest.support;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.support.SupportDTO;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("supportResource")
public class SupportResourceImpl extends BaseResourceImpl<SupportDTO> implements ISupportResource {

    public SupportResourceImpl() {
        super(SupportDTO.class, "/support");
    }

    @Override
    public SupportDTO save(SupportDTO support) {
        SupportDTO newDto = getWebResource().entity(support).post(support.getClass());
        return newDto;
    }

    @Override
    public SupportDTO getById(Integer id) {
        return null;
    }

}