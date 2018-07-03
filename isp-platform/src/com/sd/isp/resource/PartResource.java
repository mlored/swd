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

import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.service.part.IPartService;

@Path("/part")
@Component
@Secured({"ROLE_SECRETARIO", "ROLE_ADMIN"})
public class PartResource extends BaseResource {

	@Autowired
	private IPartService partService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'api_parts' + #partId")
	public PartDTO getById(@PathParam("id") Integer partId) {
		return partService.getById(partId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_MECANICO", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	@Cacheable(value=CACHE_REGION, key="'api_parts'")
	public PartResult getAll() {
		return partService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_parts'")
    @CachePut(value=CACHE_REGION, key="'api_parts' + #part.id")
	public PartDTO save(PartDTO part) {
		return partService.save(part);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'api_parts'")
    @CachePut(value=CACHE_REGION, key="'api_parts' + #id")
    public PartDTO updateById(@PathParam("id") Integer partId, @RequestBody PartDTO part) {
        return partService.updateById(partId, part);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_parts'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_parts' + #id")})
	public PartDTO delete(@PathParam("id") Integer partId) {
		return partService.delete(partId);
	}
	

	// http://localhost:8080/isp-platform/rest/part/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")

	public PartResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return partService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_MECANICO", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	public PartResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return partService.find(null, page, maxItems);
	}
}
