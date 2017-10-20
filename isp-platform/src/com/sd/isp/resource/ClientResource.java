package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.service.cliente.IClientService;

@Path("/client")
@Component
public class ClientResource {

	@Autowired
	private IClientService clientService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ClientDTO getById(@PathParam("id") Integer clientId) {
		return clientService.getById(clientId);
	}

	@GET
	@Produces("application/xml")
	public ClientResult getAll() {
		return clientService.getAll();
	}

	@POST
	public ClientDTO save(ClientDTO client) {
		return clientService.save(client);
	}
}
