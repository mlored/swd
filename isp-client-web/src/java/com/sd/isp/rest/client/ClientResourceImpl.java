package com.sd.isp.rest.client;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("clientResource")
public class ClientResourceImpl extends BaseResourceImpl<ClientDTO, ClientResult> implements IClientResource {

	public ClientResourceImpl() {
		super(ClientDTO.class, "/client", ClientResult.class);
	}

	@Override
	public ClientResult getAll() { return super.getAll(); }

	@Override
	public ClientDTO save(ClientDTO entry) {
		return super.save(entry);
	}


	@Override
	public ClientDTO getById(Integer id) {
		return super.getById(id);
	}

}
