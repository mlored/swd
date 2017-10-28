package com.sd.isp.service.car;

import com.sd.isp.dao.car.CarDaoImpl;
import com.sd.isp.domain.car.CarDomain;
import com.sd.isp.dto.location.car.CarDTO;
import com.sd.isp.dto.location.car.CarResult;
import com.sd.isp.service.base.IBaseService;

public interface ICarService extends IBaseService<CarDTO, CarDomain, CarDaoImpl, CarResult> {

}
