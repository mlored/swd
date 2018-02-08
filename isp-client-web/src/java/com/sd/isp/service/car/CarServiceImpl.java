package com.sd.isp.service.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.car.CarB;
import com.sd.isp.beans.client.ClientB;
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
    @Cacheable(value="isp-client-web-cache", key="'car_getAll'")
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
       // final CarB bean = convertDtoToBean(dto);

        return convertDtoToBean(dto);
    }

    @Override
    public CarB update(Integer id, CarB carB) {
        final CarDTO car = convertBeanToDto(carB);
        final CarDTO dto = _carResource.update(id, car);
        final CarB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public CarB delete(Integer id) {
        final CarDTO dto = _carResource.destroy(id);
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
        dto.setMark(bean.getMark());
        dto.setModel(bean.getModel());
        dto.setColor(bean.getColor());
        dto.setNumber(bean.getNumber());

        return dto;
    }
    
    public List<CarB> find (String textToFind, int maxItems, int page) {
		/*final ServiceResult result = _serviceResource.find(textToFind, maxItems, page);
		final List<ServiceDTO> rList = null == result.getServices() ? new ArrayList<ServiceDTO>()
				: result.getServices();

		final List<ServiceB> services = new ArrayList<ServiceB>();
		for (ServicetDTO dto : rList) {
			final ServiceB bean = convertDtoToBean(dto);
			services.add(bean);
		}*/
		return null;
	}
}
