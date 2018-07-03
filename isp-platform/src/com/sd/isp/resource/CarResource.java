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

import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sd.isp.service.car.ICarService;

@Path("/car")
@Component
@Secured({"ROLE_ADMIN"})
public class CarResource extends BaseResource{
	@Autowired
	private ICarService carService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value= CACHE_REGION, key="'api_cars' + #carId ")
	public CarDTO getById(@PathParam("id") Integer carId) {
		return carService.getById(carId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_MECANICO", "ROLE_SECRETARIO", "ROLE_ADMIN"})
	@Cacheable(value = CACHE_REGION,key = "'api_cars'")
	public CarResult getAll() {
		return carService.getAll();
	}

	@POST
	@CachePut(value= CACHE_REGION, key="'api_cars' + #car.id", condition = "#dto.id!=null")
	@Caching(evict = {
			@CacheEvict(value= CACHE_REGION,key = "'api_cars'"),
			})
	public CarDTO save(CarDTO car) {
		System.out.println(car.getMark());
		return carService.save(car);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value= CACHE_REGION, key = "'api_cars'")
    @CachePut(value= CACHE_REGION, key="'api_cars' + #id ")
    public CarDTO updateById(@PathParam("id") Integer carId, @RequestBody CarDTO car) {
        return carService.updateById(carId, car);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_cars'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_cars' + #id ")
            })
	public CarDTO delete(@PathParam("id") Integer carId) {
		return carService.delete(carId);
	}
	

	// http://localhost:8080/isp-platform/rest/car/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SECRETARIO", "ROLE_MECANICO", "ROLE_ADMIN"})
	public CarResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return carService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_SECRETARIO", "ROLE_MECANICO", "ROLE_ADMIN"})
	public CarResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return carService.find(null, page, maxItems);
	}
}
