package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.service.ServiceDTO;
import com.sd.isp.dto.service.ServiceResult;
import com.sd.isp.service.service.IServiceService;

@Path("/service")
@Component
public class ServiceResource {

	@Autowired
	private IServiceService serviceService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ServiceDTO getById(@PathParam("id") Integer serviceId) {
		return serviceService.getById(serviceId);
	}

	@GET
	@Produces("application/xml")
	public ServiceResult getAll() {
		return serviceService.getAll();
	}

	@POST
	public ServiceDTO save(ServiceDTO service) {
		return serviceService.save(service);
	}
}