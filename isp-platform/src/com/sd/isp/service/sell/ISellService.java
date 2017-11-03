package com.sd.isp.service.sell;

import com.sd.isp.dao.sell.SellDaoImpl;
import com.sd.isp.domain.sell.SellDomain;
import com.sd.isp.dto.sell.SellDTO;
import com.sd.isp.dto.sell.SellResult;
import com.sd.isp.service.base.IBaseService;

public interface ISellService extends IBaseService<SellDTO, SellDomain, SellDaoImpl, SellResult> {

}
