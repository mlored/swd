package com.sd.isp.service.item;

import com.sd.isp.dao.item.ItemDaoImpl;
import com.sd.isp.domain.part.ItemDomain;
import com.sd.isp.dto.item.ItemDTO;
import com.sd.isp.dto.item.ItemResult;
import com.sd.isp.service.base.IBaseService;

public interface IItemService extends IBaseService<ItemDTO, ItemDomain, ItemDaoImpl, ItemResult> {

}
