package com.sd.isp.rest.client;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("clientResource")
public class ClientResourceImpl extends BaseResourceImpl<ClientDTO> implements IClientResource {

	public ClientResourceImpl() {
		super(ClientDTO.class, "/client");
	}

	@Override
	public ClientResult getAll() {
		final ClientResult result = getWebResource().get(ClientResult.class);
		return result;
	}

}
