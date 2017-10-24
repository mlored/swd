package com.sd.isp.service.country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.country.CountryB;
import com.sd.isp.dto.location.country.CountryDTO;
import com.sd.isp.dto.location.country.CountryResult;
import com.sd.isp.rest.country.ICountryResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("countryService")
public class CountryServiceImpl extends BaseServiceImpl<CountryB, CountryDTO>
		implements ICountryService {
	@Autowired
	private ICountryResource _countryResource;
	
	
	public CountryServiceImpl() {
	}

	@Override
	public CountryB save(CountryB bean) {
		final CountryDTO dto = convertBeanToDto(bean);
		final CountryDTO countryDTO = _countryResource.save(dto);
		return convertDtoToBean(countryDTO);
	}

	@Override
	public List<CountryB> getAll() {
		final CountryResult result = _countryResource.getAll();
		final List<CountryDTO> cList = null == result.getCountries() ? new ArrayList<CountryDTO>()
				: result.getCountries();
		final List<CountryB> countries = new ArrayList<CountryB>();

		for (CountryDTO dto : cList) {
			final CountryB countryB = convertDtoToBean(dto);
			countries.add(countryB);
		}
		return countries;
	}

	@Override
	public CountryB getById(Integer id) {
		final CountryDTO dto = _countryResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected CountryB convertDtoToBean(CountryDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		final CountryB countryB = new CountryB(params);
		return countryB;
	}

	@Override
	protected CountryDTO convertBeanToDto(CountryB bean) {
		final CountryDTO dto = new CountryDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		return dto;
	}

}
