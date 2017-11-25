package com.sd.isp.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'service_getAll'"),
                       @CacheEvict(value="isp-platform-cache", key="'service_getById_'+#dto.getId()")})*/
  //  @CachePut(value = "isp-platform-cache",key="'client_getById_'+#dto.getId()", condition="#dto.getId() != null") 
	@CachePut(value = "isp-platform-cache",key="'service_save'")
	public ServiceDTO save(ServiceDTO dto) {
		final ServiceDomain serviceDomain = convertDtoToDomain(dto);
		final ServiceDomain service = serviceDao.save(serviceDomain);
		return convertDomainToDto(service);
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'service_' + #id'")
  //@Cacheable(value="isp-platform-cache", key="'service_'+#root.methodName+'_'+#id")
	public ServiceDTO getById(Integer id) {
		final ServiceDomain serviceDomain = serviceDao.getById(id);
		final ServiceDTO serviceDTO = convertDomainToDto(serviceDomain);
		return serviceDTO;
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'service_getAll'")
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
	public ServiceDTO updateById(Integer id, ServiceDTO dto) {
		final ServiceDomain newDomain = convertDtoToDomain(dto);
		final ServiceDomain domain = serviceDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setDescription(newDomain.getDescription());
		domain.setPrice(newDomain.getPrice());
		domain.setQuantity(newDomain.getQuantity());
		final ServiceDomain serviceDomain = serviceDao.save(domain);
		return convertDomainToDto(serviceDomain);
	}

	@Override
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'service_getAll'"),
			           @CacheEvict(value="isp-platform-cache", key="'service_getById_'+#dto.getId()")})*/
	public ServiceDTO delete(Integer id) {
		final ServiceDomain domain = serviceDao.delete(id);
		return convertDomainToDto(domain);
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

