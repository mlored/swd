package com.sd.isp.service.buy;

import com.sd.isp.dao.buy.BuyDaoImpl;
import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
import com.sd.isp.service.base.IBaseService;

public interface IBuyService extends IBaseService<BuyDTO, BuyDomain, BuyDaoImpl, BuyResult> {

}
