package com.sd.isp.service.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.state.StateB;
import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.rest.state.IStateResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.country.ICountryService;
@Service("stateService")
public class StateServiceImpl extends BaseServiceImpl<StateB, StateDTO> implements IStateService {
	@Autowired
	private  IStateResource _stateResource;
	@Autowired
	private ICountryService _countryService;

	public StateServiceImpl() {
	}

	@Override
	public StateB save(StateB bean) {
		final StateDTO dto = convertBeanToDto(bean);
		final StateDTO stateDTO = _stateResource.save(dto);
		return convertDtoToBean(stateDTO);
	}

	@Override
	public List<StateB> getAll() {
		final StateResult result = _stateResource.getAll();
		final List<StateDTO> sList = null == result.getStates() ? new ArrayList<StateDTO>() : result.getStates();
		final List<StateB> states = new ArrayList<StateB>();

		for (StateDTO dto : sList) {
			final StateB state = convertDtoToBean(dto);
			states.add(state);
		}
		return states;
	}

	@Override
	public StateB getById(Integer id) {
		final StateDTO dto = _stateResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected StateB convertDtoToBean(StateDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		final StateB state = new StateB(params);
		state.setCountry(_countryService.getById(dto.getCountryId()));
		return state;
	}

	@Override
	protected StateDTO convertBeanToDto(StateB bean) {
		final StateDTO dto = new StateDTO();
		dto.setId(bean.getId());
		dto.setCountryId(bean.getCountry().getId());
		dto.setName(bean.getName());
		return dto;
	}

}
