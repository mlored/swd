package com.sd.isp.rest.part;

import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IPartResource extends IBaseResource<PartDTO> {
	public PartResult getAll();
}
