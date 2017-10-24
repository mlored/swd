package com.sd.isp.rest.state;

import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IStateResource extends IBaseResource<StateDTO> {

	public StateResult getAll();
}
