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

import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.service.user.IUserService;

@Path("/user")
@Component
public class UserResource {

	@Autowired
	private IUserService userService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public UserDTO getById(@PathParam("id") Integer userId) {
		return userService.getById(userId);
	}

	@GET
	@Produces("application/xml")
	public UserResult getAll() {
		return userService.getAll();
	}

	@POST
	public UserDTO save(UserDTO user) {
		return userService.save(user);
	}
	
	@PUT
	@Path("/{id}")
    public UserDTO updateById(@PathParam("id") Integer userId, @RequestBody UserDTO user) {
        return userService.updateById(userId, user);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public UserDTO delete(@PathParam("id") Integer userId) {
		return userService.delete(userId);
	}
}
