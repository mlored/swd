package com.sd.isp.rest.buy;

import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IBuyResource extends IBaseResource<BuyDTO>{
    public BuyResult getAll();
}
