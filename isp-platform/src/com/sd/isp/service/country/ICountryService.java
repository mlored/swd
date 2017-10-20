package com.sd.isp.service.country;

import com.sd.isp.dao.country.CountryDaoImpl;
import com.sd.isp.domain.location.country.CountryDomain;
import com.sd.isp.dto.location.country.CountryDTO;
import com.sd.isp.dto.location.country.CountryResult;
import com.sd.isp.service.base.IBaseService;

public interface ICountryService extends IBaseService<CountryDTO, CountryDomain, CountryDaoImpl, CountryResult> {

}
