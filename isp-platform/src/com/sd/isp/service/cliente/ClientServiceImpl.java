package com.sd.isp.service.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.client.ClientDaoImpl;
import com.sd.isp.dao.client.IClientDao;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientDTO, ClientDomain, ClientDaoImpl, ClientResult> implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Override
	@Transactional
	public ClientDTO save(ClientDTO dto) {
		final ClientDomain clientDomain = convertDtoToDomain(dto);
		final ClientDomain client = clientDao.save(clientDomain);
		return convertDomainToDto(client);
	}

	@Override
	@Transactional
	public ClientDTO getById(Integer id) {
		final ClientDomain clientDomain = clientDao.getById(id);
		final ClientDTO clientDTO = convertDomainToDto(clientDomain);
		return clientDTO;
	}

	@Override
	@Transactional
	public ClientResult getAll() {
		final List<ClientDTO> clients = new ArrayList<>();
		for (ClientDomain domain : clientDao.findAll()) {
			final ClientDTO client = convertDomainToDto(domain);
			clients.add(client);
		}

		final ClientResult clientResult = new ClientResult();
		clientResult.setClients(clients);
		return clientResult;
	}
	
	@Override
	public ClientDTO updateById(Integer id, ClientDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ClientDTO convertDomainToDto(ClientDomain domain) {
		final ClientDTO client = new ClientDTO();
		client.setId(domain.getId());
		client.setName(domain.getName());
		client.setSurName(domain.getSurName());
		client.setRUC(domain.getRUC());
		client.setCellphone(domain.getCellphone());
		client.setAddress(domain.getAddress());
		client.setType(domain.getType());
		return client;
	}

	@Override
	protected ClientDomain convertDtoToDomain(ClientDTO dto) {
		final ClientDomain client = new ClientDomain();
		client.setId(dto.getId());
		client.setName(dto.getName());
		client.setSurName(dto.getSurName());
		client.setRUC(dto.getRUC());
		client.setCellphone(dto.getCellphone());
		client.setAddress(dto.getAddress());
		client.setType(dto.getType());
		return client;
	}

}
