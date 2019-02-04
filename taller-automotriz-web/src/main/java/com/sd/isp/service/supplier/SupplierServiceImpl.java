package com.sd.isp.service.supplier;

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

import com.sd.isp.beans.supplier.SupplierB;
import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.rest.supplier.ISupplierResource;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<SupplierB, SupplierDTO>
        implements ISupplierService {

    @Autowired
    private ISupplierResource _supplierResource;

    public SupplierServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'suppliers'")
    @CachePut(value=CACHE_REGION, key="'suppliers' + #bean.id")
    public SupplierB save(SupplierB bean) {
        final SupplierDTO supplier = convertBeanToDto(bean);
        final SupplierDTO dto = _supplierResource.save(supplier);
        final SupplierB supplierB = convertDtoToBean(dto);
        return supplierB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'suppliers'")
    public List<SupplierB> getAll() {
        final SupplierResult result = _supplierResource.getAll();
        final List<SupplierDTO> cList = null == result.getSuppliers() ? new ArrayList<SupplierDTO>()
                : result.getSuppliers();

        final List<SupplierB> suppliers = new ArrayList<SupplierB>();
        for (SupplierDTO dto : cList) {
            final SupplierB bean = convertDtoToBean(dto);
            suppliers.add(bean);
        }
        return suppliers;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'suppliers' + #id")
    public SupplierB getById(Integer id) {
        final SupplierDTO dto = _supplierResource.getById(id);
        final SupplierB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'suppliers'"),
            @CacheEvict(value=CACHE_REGION, key = "'suppliers' + #id")})
    public SupplierB delete(Integer id) {
        _supplierResource.destroy(id);
        return null;
	/*	final SupplierDTO dto = _supplierResource.destroy(id);
        final SupplierB bean = convertDtoToBean(dto);
		return bean;*/
    }

    @Override
    public SupplierB convertDtoToBean(SupplierDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("surName", dto.getSurName());
        params.put("ruc", dto.getRuc());
        params.put("address", dto.getAddress());
        params.put("cellphone", dto.getCellphone());

        final SupplierB supplierB = new SupplierB(params);

        return supplierB;
    }

    @Override
    public SupplierDTO convertBeanToDto(SupplierB bean) {
        final SupplierDTO dto = new SupplierDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setSurName(bean.getSurName());
        dto.setRuc(bean.getRuc());
        dto.setAddress(bean.getAddress());
        dto.setCellphone(bean.getCellphone());
        return dto;
    }

    @Override
    @CacheEvict(value=CACHE_REGION, key = "'suppliers'")
    @CachePut(value=CACHE_REGION, key="'suppliers' + #id")
    public SupplierB update(Integer id,  SupplierB supplierB) {
        final SupplierDTO supplier = convertBeanToDto(supplierB);
        final SupplierDTO dto  = _supplierResource.update(id, supplier);
        final SupplierB bean   = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<SupplierB> find(String textToFind, int maxItems, int page) {
        final SupplierResult result = _supplierResource.find(textToFind, maxItems, page);
        final List<SupplierDTO> rList = null == result.getSuppliers() ? new ArrayList<SupplierDTO>()
                : result.getSuppliers();

        final List<SupplierB> clients = new ArrayList<SupplierB>();
        for (SupplierDTO dto : rList) {
            final SupplierB bean = convertDtoToBean(dto);
            clients.add(bean);
        }
        return clients;
    }

}
