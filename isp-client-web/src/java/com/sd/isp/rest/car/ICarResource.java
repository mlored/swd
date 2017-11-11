package com.sd.isp.rest.car;

import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.rest.base.IBaseResource;

public interface ICarResource extends IBaseResource<CarDTO>{
    public CarResult getAll();
}
