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

import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.service.entry.IEntryService;

@Path("/entry")
@Component
@Secured({"ROLE_SECRETARIO", "ROLE_ADMIN", "ROLE_MECANICO"})
public class EntryResource extends BaseResource {

	@Autowired
	private IEntryService entryService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'api_entries' + #entry")
	public EntryDTO getById(@PathParam("id") Integer entry) {
		return entryService.getById(entry);
	}

	@GET
	@Produces("application/xml")
	@Cacheable(value=CACHE_REGION, key="'api_entries'")
	public EntryResult getAll() {
		return entryService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_entries'")
    @CachePut(value=CACHE_REGION, key="'api_entries' + #entry.id")
	public EntryDTO save(EntryDTO entry) {
		return entryService.save(entry);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'api_entries'")
    @CachePut(value=CACHE_REGION, key="'api_entries' + #id")
    public EntryDTO updateById(@PathParam("id") Integer entryId, @RequestBody EntryDTO entry) {
        return entryService.updateById(entryId, entry);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_entries'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_entries' + #id")})
	public EntryDTO delete(@PathParam("id") Integer entryId) {
		return entryService.delete(entryId);
	}
}
