package com.sd.isp.service.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.client.ClientB;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.rest.client.IClientResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("clientService")
public class ClientServiceImpl extends BaseServiceImpl<ClientB, ClientDTO>
		implements IClientService {

	@Autowired
	private IClientResource _clientResource;


	public ClientServiceImpl() {
	}

	@Override
	public ClientB save(ClientB bean) {
		final ClientDTO client = convertBeanToDto(bean);
		final ClientDTO dto = _clientResource.save(client);
		final ClientB clientB = convertDtoToBean(dto);
		return clientB;
	}

	@Override
	@Cacheable(value="isp-client-web-cache", key="'client_getAll'")
	public List<ClientB> getAll() {
		final ClientResult result = _clientResource.getAll();
		final List<ClientDTO> cList = null == result.getClients() ? new ArrayList<ClientDTO>()
				: result.getClients();

		final List<ClientB> clients = new ArrayList<ClientB>();
		for (ClientDTO dto : cList) {
			final ClientB bean = convertDtoToBean(dto);
			clients.add(bean);
		}
		return clients;
	}

	@Override
	public ClientB getById(Integer id) {
		final ClientDTO dto = _clientResource.getById(id);
		final ClientB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	public ClientB delete(Integer id) {
		return null;
	}

	@Override
	protected ClientB convertDtoToBean(ClientDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("surName", dto.getSurName());
		params.put("ruc", dto.getRUC());
		params.put("address", dto.getAddress());
		params.put("cellphone", dto.getCellphone());
		//params.put("personType", dto.getType());

		final ClientB clientB = new ClientB(params);

		return clientB;
	}

	@Override
	protected ClientDTO convertBeanToDto(ClientB bean) {
		final ClientDTO dto = new ClientDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setSurName(bean.getSurName());
		dto.setRUC(bean.getRuc());
		dto.setAddress(bean.getAddress());
		dto.setCellphone(bean.getCellphone());
		//dto.setType("ClientDomain");
		return dto;
	}

	@Override
	public ClientB update(Integer id, ClientB bean) {
		// TODO Auto-generated method stub
		return null;
	}
}
