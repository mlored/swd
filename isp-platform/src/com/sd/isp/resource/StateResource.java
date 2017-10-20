package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.service.state.IStateService;

@Path("/state")
@Component
public class StateResource {
	@Autowired
	private IStateService stateService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public StateDTO getById(@PathParam("id") Integer stateId) {
		return stateService.getById(stateId);
	}

	@GET
	@Produces("application/xml")
	public StateResult getAll() {
		return stateService.getAll();
	}

	@POST
	public StateDTO save(StateDTO state) {
		return stateService.save(state);
	}
}
