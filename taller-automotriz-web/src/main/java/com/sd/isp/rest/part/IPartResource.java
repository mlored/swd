package com.sd.isp.rest.part;

import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IPartResource extends IBaseResource<PartDTO, PartResult> {
    public PartResult getAll();
    public PartResult find(String textToFind, int maxItems, int page);
}
