package com.sd.isp.service.part;

import com.sd.isp.dao.part.PartDaoImpl;
import com.sd.isp.domain.part.ItemDomain;
import com.sd.isp.domain.part.PartDomain;
import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.service.base.IBaseService;

public interface IPartService extends IBaseService<PartDTO, PartDomain, PartDaoImpl, PartResult> {

}
