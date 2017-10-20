package com.sd.isp.service.state;

import com.sd.isp.dao.state.StateDaoImpl;
import com.sd.isp.domain.location.state.StateDomain;
import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.service.base.IBaseService;

public interface IStateService extends IBaseService<StateDTO, StateDomain, StateDaoImpl, StateResult> {

}
