package com.sd.isp.rest.supplier;


import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.rest.base.IBaseResource;

public interface ISupplierResource extends IBaseResource<SupplierDTO, SupplierResult>{
    public SupplierResult getAll();
    public SupplierResult find(String textToFind, int maxItems, int page);
}
