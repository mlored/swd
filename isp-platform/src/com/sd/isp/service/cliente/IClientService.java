package com.sd.isp.service.cliente;

import com.sd.isp.dao.client.ClientDaoImpl;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.service.base.IBaseService;

public interface IClientService extends IBaseService<ClientDTO, ClientDomain, ClientDaoImpl, ClientResult> {

}
