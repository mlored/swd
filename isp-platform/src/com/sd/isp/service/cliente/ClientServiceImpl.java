package com.sd.isp.service.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'client_getAll'"),
	                   @CacheEvict(value="isp-platform-cache", key="'client_getById_'+#dto.getId()")})*/
   // @CachePut(value = "isp-platform-cache",key="'client_getById_'+#dto.getId()", condition="#dto.getId() != null")
	 @CachePut(value = "isp-platform-cache",key="'client_save'")
	public ClientDTO save(ClientDTO dto) {
		final ClientDomain clientDomain = convertDtoToDomain(dto);
		final ClientDomain client = clientDao.save(clientDomain);
		return convertDomainToDto(client);
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'client_' + #id'")
	//@Cacheable(value="isp-platform-cache", key="'client_'+#root.methodName+'_'+#id")
	public ClientDTO getById(Integer id) {
		final ClientDomain clientDomain = clientDao.getById(id);
		final ClientDTO clientDTO = convertDomainToDto(clientDomain);
		return clientDTO;
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'client_getAll'")
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
		final ClientDomain newDomain = convertDtoToDomain(dto);
		final ClientDomain domain = clientDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getSurName());
		domain.setRUC(newDomain.getRUC());
		domain.setCellphone(newDomain.getCellphone());
		domain.setAddress(newDomain.getAddress());
		final ClientDomain clientDomain = clientDao.save(domain);
		return convertDomainToDto(clientDomain);
	}

	@Override
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'client_getAll'"),
					   @CacheEvict(value="isp-platform-cache", key="'client_getById_'+#dto.getId()")})*/
	public ClientDTO delete(Integer id) {
		final ClientDomain domain = clientDao.delete(id);
		return convertDomainToDto(domain);
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
		return client;
	}

}
