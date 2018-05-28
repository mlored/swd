package com.sd.isp.rest.part;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("partResource")
public class PartResourceImpl extends BaseResourceImpl<PartDTO, PartResult> implements IPartResource{
    
	public PartResourceImpl() {
        super(PartDTO.class, "/part", PartResult.class);
    }

    @Override
    public PartResult getAll() {
        final PartResult result = getWebResource().get(PartResult.class);
        return result;
    }
    
}
