package com.sd.isp.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.service.ServiceDaoImpl;
import com.sd.isp.dao.service.IServiceDao;
import com.sd.isp.domain.service.ServiceDomain;
import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class ServiceServiceImpl extends BaseServiceImpl<ServiceDTO, ServiceDomain, ServiceDaoImpl, ServiceResult> implements IServiceService {

	@Autowired
	private IServiceDao serviceDao;

	@Override
	@Transactional
	public ServiceDTO save(ServiceDTO dto) {
		final ServiceDomain serviceDomain = convertDtoToDomain(dto);
		final ServiceDomain service = serviceDao.save(serviceDomain);
		return convertDomainToDto(service);
	}

	@Override
	@Transactional
	public ServiceDTO getById(Integer id) {
		final ServiceDomain serviceDomain = serviceDao.getById(id);
		final ServiceDTO serviceDTO = convertDomainToDto(serviceDomain);
		return serviceDTO;
	}

	@Override
	@Transactional
	public ServiceResult getAll() {
		final List<ServiceDTO> services = new ArrayList<>();
		for (ServiceDomain domain : serviceDao.findAll()) {
			final ServiceDTO service = convertDomainToDto(domain);
			services.add(service);
		}

		final ServiceResult serviceResult = new ServiceResult();
		serviceResult.setService(services);
		return serviceResult;
	}

	@Override
	protected ServiceDTO convertDomainToDto(ServiceDomain domain) {
		final ServiceDTO service = new ServiceDTO();
		service.setId(domain.getId());
		service.setName(domain.getName());
		service.setDescription(domain.getDescription());
		service.setPrice(domain.getPrice());
		service.setQuantity(domain.getQuantity());
		return service;
	}

	@Override
	protected ServiceDomain convertDtoToDomain(ServiceDTO dto) {
		final ServiceDomain service = new ServiceDomain();
		service.setId(dto.getId());
		service.setName(dto.getName());
		service.setDescription(dto.getDescription());
		service.setPrice(dto.getPrice());
		service.setQuantity(dto.getQuantity());
		return service;
	}

}

