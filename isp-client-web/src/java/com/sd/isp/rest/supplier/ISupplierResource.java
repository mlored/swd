package com.sd.isp.rest.supplier;

import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.rest.base.IBaseResource;

public interface ISupplierResource extends IBaseResource<SupplierDTO>{
    public SupplierResult getAll();
}
