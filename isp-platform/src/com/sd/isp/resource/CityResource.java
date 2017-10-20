package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.service.city.ICityService;

@Path("/city")
@Component
public class CityResource {
	@Autowired
	private ICityService cityService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CityDTO getById(@PathParam("id") Integer cityId) {
		return cityService.getById(cityId);
	}

	@GET
	@Produces("application/xml")
	public CityResult getAll() {
		return cityService.getAll();
	}

	@POST
	public CityDTO save(CityDTO city) {
		return cityService.save(city);
	}
}
