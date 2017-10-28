package com.sd.isp.service.supplier;

import com.sd.isp.dao.supplier.SupplierDaoImpl;
import com.sd.isp.domain.supplier.SupplierDomain;
import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.service.base.IBaseService;

public interface ISupplierService extends IBaseService<SupplierDTO, SupplierDomain, SupplierDaoImpl, SupplierResult> {

}
