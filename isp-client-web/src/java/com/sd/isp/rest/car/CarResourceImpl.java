package com.sd.isp.rest.car;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("carResource")
public class CarResourceImpl extends BaseResourceImpl<CarDTO> implements ICarResource{
    public CarResourceImpl() {
        super(CarDTO.class, "/car");
    }

    @Override
    public CarResult getAll() {
        final CarResult result = getWebResource().get(CarResult.class);
        return result;
    }
}
