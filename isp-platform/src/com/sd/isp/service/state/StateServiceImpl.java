package com.sd.isp.service.state;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.state.IStateDao;
import com.sd.isp.dao.state.StateDaoImpl;
import com.sd.isp.domain.location.state.StateDomain;
import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
@Transactional
public class StateServiceImpl extends BaseServiceImpl<StateDTO, StateDomain, StateDaoImpl, StateResult> implements IStateService {
	@Autowired
	IStateDao stateDao;

	@Override
	public StateDTO save(StateDTO dto) {
		final StateDomain domain = convertDtoToDomain(dto);
		final StateDomain stateDomain = stateDao.save(domain);
		return convertDomainToDto(stateDomain);
	}

	@Override
	public StateDTO getById(Integer id) {
		final StateDomain stateDomain = stateDao.getById(id);
		return convertDomainToDto(stateDomain);
	}

	@Override
	public StateResult getAll() {
		final List<StateDTO> states = new ArrayList<>();
		for (StateDomain domain : stateDao.findAll()) {
			final StateDTO dto = convertDomainToDto(domain);
			states.add(dto);
		}

		final StateResult stateResult = new StateResult();
		stateResult.setStates(states);
		return stateResult;
	}

	@Override
	protected StateDTO convertDomainToDto(StateDomain domain) {
		final StateDTO dto = new StateDTO();
		dto.setId(domain.getId());
		dto.setCountryId(domain.getCountryId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected StateDomain convertDtoToDomain(StateDTO dto) {
		final StateDomain domain = new StateDomain();
		domain.setId(dto.getId());
		domain.setCountryId(dto.getCountryId());
		domain.setName(dto.getName());
		return domain;
	}

	@Override
	public StateDTO updateById(Integer id, StateDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
