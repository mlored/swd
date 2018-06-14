package com.sd.isp.service.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grails.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    private ICarResource carResource;


    public CarServiceImpl() {
    }

    @Override
    @Transactional
    @CacheEvict(value="${cache.name}",key = "'cars'")
    @CachePut(value="${cache.name}", key="'cars#{carB.id}'")
    public CarB save(CarB carB) {
        final CarDTO car = convertBeanToDto(carB);
        final CarDTO dto = carResource.save(car);
        final CarB newCarB = convertDtoToBean(dto);
        return newCarB;
    }

    @Override
    @Cacheable(value="${cache.name}", key="'cars'")
    public List<CarB> getAll() {
        final CarResult result = carResource.getAll();
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
    @Cacheable(value="${cache.name}", key="'cars' + #id ")
    public CarB getById(Integer id) {
        final CarDTO dto = carResource.getById(id);
        return convertDtoToBean(dto);
    }

    @Override
    @CacheEvict(value="${cache.name}", key = "'cars'")
    @CachePut(value="${cache.name}", key="'cars#id'")
    public CarB update(Integer id, CarB carB) {
        final CarDTO car = convertBeanToDto(carB);
        final CarDTO dto = carResource.update(id, car);
        final CarB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value="${cache.name}", key = "'cars'"),
            @CacheEvict(value="${cache.name}", key = "'cars#id'")})
    public CarB delete(Integer id) {
        final CarDTO dto = carResource.destroy(id);
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
