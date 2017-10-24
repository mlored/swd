package com.sd.isp.rest.state;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("stateResource")
public class StateResourceImpl extends BaseResourceImpl<StateDTO> implements IStateResource {

	public StateResourceImpl() {
		super(StateDTO.class, "/state");
	}

	@Override
	public StateResult getAll() {
		return getWebResource().get(StateResult.class);
	}

}
