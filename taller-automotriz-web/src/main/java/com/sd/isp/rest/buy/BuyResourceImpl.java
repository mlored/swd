package com.sd.isp.rest.buy;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("buyResource")
public class BuyResourceImpl extends BaseResourceImpl<BuyDTO, BuyResult> implements IBuyResource{
    public BuyResourceImpl() {
        super(BuyDTO.class, "/buy", BuyResult.class);
    }

    @Override
    public BuyResult getAll() {
        return super.getAll();
    }
}
