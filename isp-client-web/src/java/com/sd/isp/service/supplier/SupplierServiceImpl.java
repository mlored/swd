package com.sd.isp.service.supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	public SupplierB save(SupplierB bean) {
		final SupplierDTO supplier = convertBeanToDto(bean);
		final SupplierDTO dto = _supplierResource.save(supplier);
		final SupplierB supplierB = convertDtoToBean(dto);
		return supplierB;
	}

	@Override
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
	public SupplierB getById(Integer id) {
		final SupplierDTO dto = _supplierResource.getById(id);
		final SupplierB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected SupplierB convertDtoToBean(SupplierDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("surName", dto.getSurName());
		params.put("ruc", dto.getRuc());
		params.put("address", dto.getAddress());
		//params.put("cellphone", dto.getCellphone());

		final SupplierB supplierB = new SupplierB(params);

		return supplierB;
	}

	@Override
	protected SupplierDTO convertBeanToDto(SupplierB bean) {
		final SupplierDTO dto = new SupplierDTO();
		dto.setId(bean.getId());
		//dto.setDocument(bean.getDocument());
		//dto.setFirstName(bean.getFirstName());
		//dto.setLastName(bean.getLastName());
		return dto;
	}
}
