package com.sd.isp.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.service.car.ICarService;

@Path("/car")
@Component
public class CarResource {
	@Autowired
	private ICarService carService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPER", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	public CarDTO getById(@PathParam("id") Integer carId) {
		return carService.getById(carId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPER", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	public CarResult getAll() {
		return carService.getAll();
	}

	@POST
	@Secured({"ROLE_SUPER", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	public CarDTO save(CarDTO car) {
		System.out.println(car.getMark());
		return carService.save(car);
	}
	
	@PUT
	@Path("/{id}")
	@Secured({"ROLE_SUPER", "ROLE_SECRETARIO", "ROLE_ADMIN"})
    public CarDTO updateById(@PathParam("id") Integer carId, @RequestBody CarDTO car) {
        return carService.updateById(carId, car);
    }
	
	@DELETE
	@Path("/{id}")
	@Secured({"ROLE_SUPER", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	@Produces("application/json")
	public CarDTO delete(@PathParam("id") Integer carId) {
		return carService.delete(carId);
	}
}
