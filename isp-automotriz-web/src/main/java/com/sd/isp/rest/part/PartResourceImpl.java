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
        return super.getAll();
    }

    @Override
    public PartResult find(String textToFind, int maxItems, int page) {
        //setWebResourceBasicAuthFilter();
        final PartResult result = findWR(textToFind, maxItems, page);
        return result;
    }

}
