package com.sd.isp.service.city;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.city.CityB;
import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.rest.city.ICityResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.country.ICountryService;
import com.sd.isp.service.state.IStateService;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<CityB, CityDTO> implements
		ICityService {
	@Autowired
	private ICountryService _countryService;
	@Autowired
	private IStateService _stateService;
	@Autowired
	private ICityResource _cityResource;

	public CityServiceImpl() {
	}

	@Override
	public CityB save(CityB bean) {
		final CityDTO dto = convertBeanToDto(bean);
		final CityDTO cityDTO = _cityResource.save(dto);
		return convertDtoToBean(cityDTO);
	}

	@Override
	public List<CityB> getAll() {
		final CityResult result = _cityResource.getAll();
		final List<CityDTO> cList = null == result.getCities() ? new ArrayList<CityDTO>()
				: result.getCities();
		final List<CityB> cities = new ArrayList<CityB>();
		for (CityDTO dto : cList) {
			final CityB city = convertDtoToBean(dto);
			cities.add(city);
		}
		return cities;
	}

	@Override
	public CityB getById(Integer id) {
		final CityDTO dto = _cityResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected CityB convertDtoToBean(CityDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		final CityB city = new CityB(params);
		city.setCountry(_countryService.getById(dto.getCountryId()));
		city.setState(_stateService.getById(dto.getStateId()));
		return city;

	}

	@Override
	protected CityDTO convertBeanToDto(CityB bean) {
		final CityDTO dto = new CityDTO();
		dto.setId(bean.getId());
		dto.setCountryId(bean.getCountry().getId());
		dto.setStateId(bean.getState().getId());
		dto.setName(bean.getName());
		return dto;
	}

}
