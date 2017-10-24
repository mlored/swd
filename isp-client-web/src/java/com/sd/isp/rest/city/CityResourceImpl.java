package com.sd.isp.rest.city;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("cityResouce")
public class CityResourceImpl extends BaseResourceImpl<CityDTO> implements ICityResource {

	public CityResourceImpl() {
		super(CityDTO.class, "/city");
	}

	@Override
	public CityResult getAll() {
		return getWebResource().get(CityResult.class);
	}

}
