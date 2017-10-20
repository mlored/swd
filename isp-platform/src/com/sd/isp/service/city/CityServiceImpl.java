package com.sd.isp.service.city;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.city.CityDaoImpl;
import com.sd.isp.dao.city.ICityDao;
import com.sd.isp.domain.location.city.CityDomain;
import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class CityServiceImpl extends BaseServiceImpl<CityDTO, CityDomain, CityDaoImpl, CityResult> implements ICityService {
	@Autowired
	private ICityDao cityDao;

	@Override
	@Transactional
	public CityDTO save(CityDTO dto) {
		final CityDomain domain = convertDtoToDomain(dto);
		final CityDomain cityDomain = cityDao.save(domain);
		return convertDomainToDto(cityDomain);
	}

	@Override
	@Transactional
	public CityDTO getById(Integer id) {
		final CityDomain domain = cityDao.getById(id);
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	public CityResult getAll() {
		final List<CityDTO> cities = new ArrayList<>();
		for (CityDomain domain : cityDao.findAll()) {
			final CityDTO dto = convertDomainToDto(domain);
			cities.add(dto);
		}

		final CityResult cityResult = new CityResult();
		cityResult.setCities(cities);
		return cityResult;
	}

	@Override
	protected CityDTO convertDomainToDto(CityDomain domain) {
		final CityDTO dto = new CityDTO();
		dto.setId(domain.getId());
		dto.setCountryId(domain.getCountryId());
		dto.setStateId(domain.getStateId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected CityDomain convertDtoToDomain(CityDTO dto) {
		final CityDomain domain = new CityDomain();
		domain.setId(dto.getId());
		domain.setCountryId(dto.getCountryId());
		domain.setStateId(dto.getStateId());
		domain.setName(dto.getName());
		return domain;
	}

}
