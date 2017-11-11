package com.sd.isp.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.service.role.IRoleService;

@Path("/role")
@Component
public class RoleResource {

	@Autowired
	private IRoleService roleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public RoleDTO getById(@PathParam("id") Integer roleId) {
		return roleService.getById(roleId);
	}

	@GET
	@Produces("application/xml")
	public RoleResult getAll() {
		return roleService.getAll();
	}

	@POST
	public RoleDTO save(RoleDTO role) {
		return roleService.save(role);
	}
	
	@PUT
	@Path("/{id}")
    public RoleDTO updateById(@PathParam("id") Integer roleId, @RequestBody RoleDTO role) {
        return roleService.updateById(roleId, role);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public RoleDTO delete(@PathParam("id") Integer roleId) {
		return roleService.delete(roleId);
	}
}
