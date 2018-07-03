package com.sd.isp.resource;

import java.util.HashMap;
import java.util.Map;

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
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.service.role.IRoleService;

@Path("/role")
@Component
@Secured({"ROLE_ADMIN"})
public class RoleResource extends BaseResource {

	@Autowired
	private IRoleService roleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'api_roles' + #roleId")
	public RoleDTO getById(@PathParam("id") Integer roleId) {
		return roleService.getById(roleId);
	}

	@GET
	@Path("/authority/{authority}")
	@Produces("application/xml")
	public RoleResult getAllBy(@PathParam("authority") String authority){
		Map<String, String> args = new HashMap<>();
		args.put("authority", authority);
		return roleService.getAllBy(args);
	}
	
	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SECRETARIO", "ROLE_ADMIN", "ROLE_MECANICO"})
	@Cacheable(value=CACHE_REGION, key="'api_roles'")
	public RoleResult getAll() {
		return roleService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_roles'")
    @CachePut(value=CACHE_REGION, key="'api_roles' + #role.id")
	public RoleDTO save(RoleDTO role) {
		return roleService.save(role);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'api_roles'")
    @CachePut(value=CACHE_REGION, key="'api_roles' + #id")
    public RoleDTO updateById(@PathParam("id") Integer roleId, @RequestBody RoleDTO role) {
        return roleService.updateById(roleId, role);
    }
	
	@DELETE
	@Path("/{id}")
	//@Produces("application/json")
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_roles'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_roles' + #id")})
	public RoleDTO delete(@PathParam("id") Integer roleId) {
		return roleService.delete(roleId);
	}
	
}
