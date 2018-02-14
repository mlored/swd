package com.sd.isp.rest.supplier;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("supplierResource")
public class SupplierResourceImpl extends BaseResourceImpl<SupplierDTO, SupplierResult> implements ISupplierResource {

	public SupplierResourceImpl() {
		super(SupplierDTO.class, "/supplier", SupplierResult.class);
	}

	@Override
	public SupplierResult getAll() {
		final SupplierResult result = getWebResource().get(SupplierResult.class);
		return result;
	}

}
