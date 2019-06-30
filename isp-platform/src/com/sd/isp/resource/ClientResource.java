package com.sd.isp.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.service.cliente.IClientService;

@Path("/client")
@Component
public class ClientResource extends BaseResource{

	@Autowired
	private IClientService clientService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMIN", "ROLE_SECRETARIO","ROLE_MECANICO"})
	@Cacheable(value=CACHE_REGION, key="'api_clients' + #clientId")
	public ClientDTO getById(@PathParam("id") Integer clientId) {
		return clientService.getById(clientId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_ADMIN", "ROLE_SECRETARIO","ROLE_MECANICO"})
	@Cacheable(value=CACHE_REGION, key="'api_clients'")
	public ClientResult getAll() {
		return clientService.getAll();
	}

	@POST
	@Secured({"ROLE_ADMIN", "ROLE_SECRETARIO"})
	@CacheEvict(value=CACHE_REGION,key = "'api_clients'")
	@CachePut(value=CACHE_REGION, key="'api_clients' + #client.id")
	public ClientDTO save(ClientDTO client) {
		return clientService.save(client);
	}
	
	@PUT
	@Path("/{id}")
	@Secured({"ROLE_ADMIN", "ROLE_SECRETARIO"})
	@CacheEvict(value=CACHE_REGION, key = "'api_clients'")
	@CachePut(value=CACHE_REGION, key="'api_clients' + #id")
    public ClientDTO updateById(@PathParam("id") Integer clientId, @RequestBody ClientDTO client) {
        return clientService.updateById(clientId, client);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMIN"})
	@Caching(evict = {
			@CacheEvict(value=CACHE_REGION, key = "'api_clients'"),
			@CacheEvict(value=CACHE_REGION, key = "'api_clients' + #id")})
	public ClientDTO delete(@PathParam("id") Integer clientId) {
		return clientService.delete(clientId);
	}
	

	// http://localhost:8080/isp-platform/rest/client/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMIN", "ROLE_SECRETARIO","ROLE_MECANICO"})
	public ClientResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return clientService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMIN", "ROLE_SECRETARIO","ROLE_MECANICO"})
	public ClientResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return clientService.find(null, page, maxItems);
	}
}
