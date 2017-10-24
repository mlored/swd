package com.sd.isp.rest.city;

import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.rest.base.IBaseResource;

public interface ICityResource extends IBaseResource<CityDTO> {

	public CityResult getAll();
}
