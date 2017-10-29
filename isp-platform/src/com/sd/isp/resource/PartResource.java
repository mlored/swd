package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.service.part.IPartService;

@Path("/part")
@Component
public class PartResource {

	@Autowired
	private IPartService partService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public PartDTO getById(@PathParam("id") Integer partId) {
		return partService.getById(partId);
	}

	@GET
	@Produces("application/xml")
	public PartResult getAll() {
		return partService.getAll();
	}

	@POST
	public PartDTO save(PartDTO part) {
		return partService.save(part);
	}
}
