package com.sd.isp.rest.country;

import com.sd.isp.dto.location.country.CountryDTO;
import com.sd.isp.dto.location.country.CountryResult;
import com.sd.isp.rest.base.IBaseResource;

public interface ICountryResource extends IBaseResource<CountryDTO> {
	public CountryResult getAll();
}
