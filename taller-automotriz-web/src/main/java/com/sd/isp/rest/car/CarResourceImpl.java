package com.sd.isp.rest.car;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("carResource")
public class CarResourceImpl extends BaseResourceImpl<CarDTO, CarResult> implements ICarResource{
    public CarResourceImpl() {
        super(CarDTO.class, "/car", CarResult.class);
    }

    @Override
    public CarResult getAll() { return super.getAll(); }

    @Override
    public CarDTO save(CarDTO entry) {
        return super.save(entry);
    }


    @Override
    public CarDTO getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public CarResult find(String textToFind, int maxItems, int page) {
        //setWebResourceBasicAuthFilter();
        final CarResult result = findWR(textToFind, maxItems, page);
        return result;
    }
}
