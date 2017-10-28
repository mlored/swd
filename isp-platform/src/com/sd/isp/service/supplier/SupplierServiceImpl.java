package com.sd.isp.service.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.supplier.SupplierDaoImpl;
import com.sd.isp.dao.supplier.ISupplierDao;
import com.sd.isp.domain.supplier.SupplierDomain;
import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<SupplierDTO, SupplierDomain, SupplierDaoImpl, SupplierResult> implements ISupplierService {

	@Autowired
	private ISupplierDao supplierDao;

	@Override
	@Transactional
	public SupplierDTO save(SupplierDTO dto) {
		final SupplierDomain supplierDomain = convertDtoToDomain(dto);
		final SupplierDomain supplier = supplierDao.save(supplierDomain);
		return convertDomainToDto(supplier);
	}

	@Override
	@Transactional
	public SupplierDTO getById(Integer id) {
		final SupplierDomain supplierDomain = supplierDao.getById(id);
		final SupplierDTO supplierDTO = convertDomainToDto(supplierDomain);
		return supplierDTO;
	}

	@Override
	@Transactional
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
	protected SupplierDTO convertDomainToDto(SupplierDomain domain) {
		final SupplierDTO supplier = new SupplierDTO();
		supplier.setId(domain.getId());
		supplier.setName(domain.getName());
		supplier.setSurName(domain.getSurName());
		supplier.setRuc(domain.getRuc());
		supplier.setAddress(domain.getAddress());
		supplier.setType(domain.getType());
		supplier.setCellphone(domain.getCellphone());
		return supplier;
	}

	@Override
	protected SupplierDomain convertDtoToDomain(SupplierDTO dto) {
		final SupplierDomain supplier = new SupplierDomain();
		supplier.setId(dto.getId());
		supplier.setName(dto.getName());
		supplier.setSurName(dto.getSurName());
		supplier.setRuc(dto.getRuc());
		supplier.setAddress(dto.getAddress());
		supplier.setType(dto.getType());
		supplier.setCellphone(dto.getCellphone());
		return supplier;
	}

}
