package com.sd.isp.service.city;

import com.sd.isp.dao.city.CityDaoImpl;
import com.sd.isp.domain.location.city.CityDomain;
import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.service.base.IBaseService;

public interface ICityService extends IBaseService<CityDTO, CityDomain, CityDaoImpl, CityResult> {

}
