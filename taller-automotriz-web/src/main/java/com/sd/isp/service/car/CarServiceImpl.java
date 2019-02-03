package com.sd.isp.service.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.isp.rest.car.CarResourceImpl;
import grails.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    private ICarResource carResource = new CarResourceImpl();


    public CarServiceImpl() {
    }

    @Override
    @Transactional
    @CacheEvict(value= CACHE_REGION,key = "'cars'")
    @CachePut(value= CACHE_REGION, key="'cars' + #carB.id")
    public CarB save(CarB carB) {
        final CarDTO car = convertBeanToDto(carB);
        final CarDTO dto = carResource.save(car);
        final CarB newCarB = convertDtoToBean(dto);
        return newCarB;
    }

    @Override
    @Cacheable(value= CACHE_REGION, key="'cars'")
    public List<CarB> getAll() {
      //  System.out.println(myBean.foo());
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
    @Cacheable(value= CACHE_REGION, key="'cars' + #id ")
    public CarB getById(Integer id) {
        final CarDTO dto = carResource.getById(id);
        return convertDtoToBean(dto);
    }

    @Override
    @CacheEvict(value= CACHE_REGION, key = "'cars'")
    @CachePut(value= CACHE_REGION, key="'cars' + #id ")
    public CarB update(Integer id, CarB carB) {
        final CarDTO car = convertBeanToDto(carB);
        final CarDTO dto = carResource.update(id, car);
        final CarB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'cars'"),
            @CacheEvict(value=CACHE_REGION, key = "'cars' + #id ")})
    public CarB delete(Integer id) {
        final CarDTO dto = carResource.destroy(id);
        final CarB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public CarB convertDtoToBean(CarDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("mark", dto.getMark());
        params.put("model", dto.getModel());
        params.put("color", dto.getColor());
        params.put("year", String.valueOf(dto.getYear()));

        final CarB carB = new CarB(params);

        return carB;
    }

    @Override
    public CarDTO convertBeanToDto(CarB bean) {
        final CarDTO dto = new CarDTO();
        dto.setId(bean.getId());
        dto.setMark(bean.getMark());
        dto.setModel(bean.getModel());
        dto.setColor(bean.getColor());
        dto.setYear(bean.getYear());

        return dto;
    }

    @Override
    public List<CarB> find(String textToFind, int maxItems, int page) {
        final CarResult result = carResource.find(textToFind, maxItems, page);
        final List<CarDTO> rList = null == result.getCars() ? new ArrayList<CarDTO>()
                : result.getCars();

        final List<CarB> cars = new ArrayList<CarB>();
        for (CarDTO dto : rList) {
            final CarB bean = convertDtoToBean(dto);
            cars.add(bean);
        }
        return cars;
    }
}
