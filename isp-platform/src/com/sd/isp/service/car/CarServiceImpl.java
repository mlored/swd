package com.sd.isp.service.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.car.CarDaoImpl;
import com.sd.isp.dao.car.ICarDao;
import com.sd.isp.domain.car.CarDomain;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class CarServiceImpl extends BaseServiceImpl<CarDTO, CarDomain, CarDaoImpl, CarResult> implements ICarService {
	@Autowired
	private ICarDao carDao;
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "isp-platform-cache")
	public CarResult getAll() {
		final List<CarDTO> cars = new ArrayList<>();
		for (CarDomain domain : carDao.findAll()) {
			final CarDTO dto = convertDomainToDto(domain);
			cars.add(dto);
		}

		final CarResult carResult = new CarResult();
		carResult.setCars(cars);
		return carResult;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "isp-platform-cache")
	public CarDTO getById(Integer id) {
		final CarDomain domain = carDao.getById(id);
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	@CacheEvict(value= "isp-platform-cache", allEntries=true)
	public CarDTO save(CarDTO dto) {
		final CarDomain domain = convertDtoToDomain(dto);
		final CarDomain carDomain = carDao.save(domain);
		return convertDomainToDto(carDomain);
	}
	
	@Override
	@Transactional
	@CacheEvict(value= "isp-platform-cache", allEntries=true)
	public CarDTO updateById(Integer id, CarDTO dto) {
		final CarDomain newDomain = convertDtoToDomain(dto);
		final CarDomain domain = carDao.getById(id);
		domain.setMark(newDomain.getMark());
		domain.setModel(newDomain.getModel());
		domain.setColor(newDomain.getColor());
		domain.setNumber(newDomain.getNumber());
		final CarDomain carDomain = carDao.save(domain);
		return convertDomainToDto(carDomain);
	}

	@Override
	@Transactional
	@CacheEvict(value= "isp-platform-cache", allEntries=true)
	public CarDTO delete(Integer id) {
		final CarDomain domain = carDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected CarDTO convertDomainToDto(CarDomain domain) {
		final CarDTO dto = new CarDTO();
		dto.setId(domain.getId());
		dto.setMark(domain.getMark());
		dto.setModel(domain.getModel());
		dto.setNumber(domain.getNumber());
		dto.setColor(domain.getColor());
		return dto;
	}

	@Override
	protected CarDomain convertDtoToDomain(CarDTO dto) {
		final CarDomain domain = new CarDomain();
		domain.setId(dto.getId());
		domain.setMark(dto.getMark());
		domain.setModel(dto.getModel());
		domain.setNumber(dto.getNumber());
		domain.setColor(dto.getColor());
		return domain;
	}

}