package com.sd.isp.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.service.ServiceB;
import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.rest.service.IServiceResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("serviceService")
public class ServiceServiceImpl extends BaseServiceImpl<ServiceB, ServiceDTO>
        implements IServiceService {

    @Autowired
    private IServiceResource _serviceResource;


    public ServiceServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'services'")
    @CachePut(value=CACHE_REGION, key="'services' + #bean.id")
    public ServiceB save(ServiceB bean) {
        final ServiceDTO service = convertBeanToDto(bean);
        final ServiceDTO dto = _serviceResource.save(service);
        final ServiceB serviceB = convertDtoToBean(dto);
        return serviceB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'services'")
    public List<ServiceB> getAll() {
        final ServiceResult result = _serviceResource.getAll();
        final List<ServiceDTO> cList = null == result.getServices() ? new ArrayList<ServiceDTO>()
                : result.getServices();

        final List<ServiceB> services = new ArrayList<ServiceB>();
        for (ServiceDTO dto : cList) {
            final ServiceB bean = convertDtoToBean(dto);
            services.add(bean);
        }
        return services;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'services' + #id")
    public ServiceB getById(Integer id) {
        final ServiceDTO dto = _serviceResource.getById(id);
        final ServiceB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'services'"),
            @CacheEvict(value=CACHE_REGION, key = "'services' + #id")})
    public ServiceB delete(Integer id) {
        final ServiceDTO dto = _serviceResource.destroy(id);
        final ServiceB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public ServiceB convertDtoToBean(ServiceDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("description", dto.getDescription());
        params.put("price", String.valueOf(dto.getPrice()));
        params.put("quantity", String.valueOf(dto.getQuantity()));

        final ServiceB serviceB = new ServiceB(params);

        return serviceB;
    }

    @Override
    public ServiceDTO convertBeanToDto(ServiceB bean) {
        final ServiceDTO dto = new ServiceDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());
        dto.setPrice(bean.getPrice());
        dto.setQuantity(bean.getQuantity());
        return dto;
    }

    @Override
    @CacheEvict(value=CACHE_REGION, key = "'services'")
    @CachePut(value=CACHE_REGION, key="'services' + #id")
    public ServiceB update(Integer id,  ServiceB serviceB) {
        final ServiceDTO service = convertBeanToDto(serviceB);
        final ServiceDTO dto  	  = _serviceResource.update(id, service);
        final ServiceB bean       = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<ServiceB> find(String textToFind, int maxItems, int page) {
        final ServiceResult result = _serviceResource.find(textToFind, maxItems, page);
        final List<ServiceDTO> rList = null == result.getServices() ? new ArrayList<ServiceDTO>()
                : result.getServices();

        final List<ServiceB> services = new ArrayList<ServiceB>();
        for (ServiceDTO dto : rList) {
            final ServiceB bean = convertDtoToBean(dto);
            services.add(bean);
        }
        return services;
    }
}