package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.location.car.CarDTO;
import com.sd.isp.dto.location.car.CarResult;
import com.sd.isp.service.car.ICarService;

@Path("/car")
@Component
public class CarResource {
	@Autowired
	private ICarService carService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CarDTO getById(@PathParam("id") Integer carId) {
		return carService.getById(carId);
	}

	@GET
	@Produces("application/xml")
	public CarResult getAll() {
		return carService.getAll();
	}

	@POST
	public CarDTO save(CarDTO car) {
		return carService.save(car);
	}
}
