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

import com.sd.isp.dto.entry_details.EntryDetailsDTO;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.service.entryDetails.IEntryDetailsService;

@Path("/entryDetails")
@Component
@Secured({"ROLE_SECRETARIO", "ROLE_ADMIN"})
public class EntryDetailsResource extends BaseResource {

	@Autowired
	private IEntryDetailsService entryDetailsService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'api_entry_details' + #entryDetails")
	public EntryDetailsDTO getById(@PathParam("id") Integer entryDetails) {
		return entryDetailsService.getById(entryDetails);
	}

	@GET
	@Produces("application/xml")
	@Cacheable(value=CACHE_REGION, key="'api_entry_details'")
	public EntryDetailsResult getAll() {
		return entryDetailsService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_entry_details'")
    @CachePut(value=CACHE_REGION, key="'api_entry_details' + #entryDetails.id")
	public EntryDetailsDTO save(EntryDetailsDTO entryDetails) {
		return entryDetailsService.save(entryDetails);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'api_entry_details'")
    @CachePut(value=CACHE_REGION, key="'api_entry_details' + #id")
    public EntryDetailsDTO updateById(@PathParam("id") Integer entryDetailsId, @RequestBody EntryDetailsDTO entryDetails) {
        return entryDetailsService.updateById(entryDetailsId, entryDetails);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_entry_details'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_entry_details' + #id")})
	public EntryDetailsDTO delete(@PathParam("id") Integer entryDetailsId) {
		return entryDetailsService.delete(entryDetailsId);
	}
}
