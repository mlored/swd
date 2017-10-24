package com.sd.isp.rest.client;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IClientResource extends IBaseResource<ClientDTO> {

	public ClientResult getAll();

}
