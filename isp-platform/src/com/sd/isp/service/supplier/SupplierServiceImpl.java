package com.sd.isp.service.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.supplier.SupplierDaoImpl;
import com.sd.isp.dao.supplier.ISupplierDao;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.domain.supplier.SupplierDomain;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<SupplierDTO, SupplierDomain, SupplierDaoImpl, SupplierResult> implements ISupplierService {

	@Autowired
	private ISupplierDao supplierDao;

	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION,key = "'api_suppliers'")
	@CachePut(value=CACHE_REGION, key="'api_suppliers' + #dto.id")
	public SupplierDTO save(SupplierDTO dto) {
		final SupplierDomain supplierDomain = convertDtoToDomain(dto);
		final SupplierDomain supplier = supplierDao.save(supplierDomain);
		return convertDomainToDto(supplier);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_suppliers' + #id")
	public SupplierDTO getById(Integer id) {
		final SupplierDomain supplierDomain = supplierDao.getById(id);
		//final SupplierDTO supplierDTO = convertDomainToDto(supplierDomain);
		return convertDomainToDto(supplierDomain);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value=CACHE_REGION, key="'api_suppliers'")
	public SupplierResult getAll() {
		final List<SupplierDTO> suppliers = new ArrayList<>();
		for (SupplierDomain domain : supplierDao.findAll()) {
			final SupplierDTO supplier = convertDomainToDto(domain);
			suppliers.add(supplier);
		}

		final SupplierResult supplierResult = new SupplierResult();
		supplierResult.setSuppliers(suppliers);
		return supplierResult;
	}
	
	@Override
	@Transactional
	@CacheEvict(value=CACHE_REGION, key = "'suppliers'")
	@CachePut(value=CACHE_REGION, key="'suppliers' + #id")
	public SupplierDTO updateById(Integer id, SupplierDTO dto) {
		final SupplierDomain newDomain = convertDtoToDomain(dto);
		final SupplierDomain domain = supplierDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getSurName());
		domain.setRUC(newDomain.getRUC());
		domain.setAddress(newDomain.getAddress());
		final SupplierDomain supplierDomain = supplierDao.save(domain);
		return convertDomainToDto(supplierDomain);
	}

	@Override
	@Transactional
	@Caching(evict = {
			@CacheEvict(value=CACHE_REGION, key = "'api_suppliers'"),
			@CacheEvict(value=CACHE_REGION, key = "'api_suppliers' + #id")})
	public SupplierDTO delete(Integer id) {
		final SupplierDomain domain = supplierDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected SupplierDTO convertDomainToDto(SupplierDomain domain) {
		final SupplierDTO supplier = new SupplierDTO();
		supplier.setId(domain.getId());
		supplier.setName(domain.getName());
		supplier.setSurName(domain.getSurName());
		supplier.setRuc(domain.getRUC());
		supplier.setAddress(domain.getAddress());
		supplier.setCellphone(domain.getCellphone());
		return supplier;
	}

	@Override
	protected SupplierDomain convertDtoToDomain(SupplierDTO dto) {
		final SupplierDomain supplier = new SupplierDomain();
		supplier.setId(dto.getId());
		supplier.setName(dto.getName());
		supplier.setSurName(dto.getSurName());
		supplier.setRUC(dto.getRuc());
		supplier.setAddress(dto.getAddress());
		supplier.setCellphone(dto.getCellphone());
		return supplier;
	}
	
	@Override
	@Transactional(readOnly = true)
	public SupplierResult find(String textToFind, int page, int maxItems) throws Exception {
		final List<SupplierDTO> suppliers = new ArrayList<>();
		for (SupplierDomain domain : supplierDao.find(textToFind, page, maxItems)) {
			final SupplierDTO dto = convertDomainToDto(domain);
			suppliers.add(dto);
		}
		final SupplierResult supplierResult = new SupplierResult();
		supplierResult.setSuppliers(suppliers);
		return supplierResult;
	}

}
