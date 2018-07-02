package com.sd.isp.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.service.cliente.IClientService;

@Path("/client")
@Component
@Secured("ROLE_SECRETARIO")
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
	@Secured({"ROLE_MECANICO", "ROLE_SECRETARIO"})
	public ClientResult getAll() {
		return clientService.getAll();
	}

	@POST
	public ClientDTO save(ClientDTO client) {
		return clientService.save(client);
	}
	
	@PUT
	@Path("/{id}")
    public ClientDTO updateById(@PathParam("id") Integer clientId, @RequestBody ClientDTO client) {
        return clientService.updateById(clientId, client);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public ClientDTO delete(@PathParam("id") Integer clientId) {
		return clientService.delete(clientId);
	}
	

	// http://localhost:8080/isp-platform/rest/client/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public ClientResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return clientService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_MECANICO", "ROLE_SECRETARIO"})
	public ClientResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return clientService.find(null, page, maxItems);
	}
}
