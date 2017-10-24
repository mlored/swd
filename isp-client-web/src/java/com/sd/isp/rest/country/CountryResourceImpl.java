package com.sd.isp.rest.country;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.location.country.CountryDTO;
import com.sd.isp.dto.location.country.CountryResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("countryResource")
public class CountryResourceImpl extends BaseResourceImpl<CountryDTO> implements
		ICountryResource {

	public CountryResourceImpl() {
		super(CountryDTO.class, "/country");
	}

	@Override
	@CacheEvict(value = "isp-client-web-cache")
	public CountryDTO save(CountryDTO dto) {
		final CountryDTO country = getWebResource().entity(dto).post(
				getDtoClass());
		return country;
	}

	@Override
	@Cacheable(value="isp-client-web-cache")
	public CountryResult getAll() {
		return getWebResource().get(CountryResult.class);
	}
	
	@Override
	@Cacheable(value="isp-client-web-cache")
	public CountryDTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

}
