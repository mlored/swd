package com.sd.isp.service.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.car.CarB;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.rest.car.ICarResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("carService")
public class CarServiceImpl extends BaseServiceImpl<CarB, CarDTO>
        implements ICarService {

    @Autowired
    private ICarResource _carResource;


    public CarServiceImpl() {
    }

    @Override
    public CarB save(CarB bean) {
        final CarDTO car = convertBeanToDto(bean);
        final CarDTO dto = _carResource.save(car);
        final CarB carB = convertDtoToBean(dto);
        return carB;
    }

    @Override
    public List<CarB> getAll() {
        final CarResult result = _carResource.getAll();
        final List<CarDTO> cList = null == result.getCars() ? new ArrayList<CarDTO>()
                : result.getCars();

        final List<CarB> cars = new ArrayList<CarB>();
        for (CarDTO dto : cList) {
            final CarB bean = convertDtoToBean(dto);
            cars.add(bean);
        }
        return cars;
    }

    @Override
    public CarB getById(Integer id) {
        final CarDTO dto = _carResource.getById(id);
        final CarB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected CarB convertDtoToBean(CarDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("mark", dto.getMark());
        params.put("model", dto.getModel());
        params.put("color", dto.getColor());
        params.put("number", dto.getNumber());

        final CarB carB = new CarB(params);

        return carB;
    }

    @Override
    protected CarDTO convertBeanToDto(CarB bean) {
        final CarDTO dto = new CarDTO();
        dto.setId(bean.getId());
        //dto.setDocument(bean.getDocument());
        //dto.setFirstName(bean.getFirstName());
        //dto.setLastName(bean.getLastName());
        return dto;
    }
}
