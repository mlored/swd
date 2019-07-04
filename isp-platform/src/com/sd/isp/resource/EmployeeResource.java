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

import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.service.employee.IEmployeeService;

@Path("/employee")
@Component
@Secured({"ROLE_ADMIN"})
public class EmployeeResource extends BaseResource {

	@Autowired
	private IEmployeeService employeeService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'api_employees' + #employeeId")
	public EmployeeDTO getById(@PathParam("id") Integer employeeId) {
		return employeeService.getById(employeeId);
	}

	@GET
	@Produces("application/xml")
	@Cacheable(value=CACHE_REGION, key="'api_employees'")
	public EmployeeResult getAll() {
		return employeeService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_employees'")
	@CachePut(value=CACHE_REGION, key="'api_employees' + #employee.id")
	public EmployeeDTO save(EmployeeDTO employee) {
		return employeeService.save(employee);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'api_employees'")
	@CachePut(value=CACHE_REGION, key="'api_employees' + #id")
    public EmployeeDTO updateById(@PathParam("id") Integer employeeId, @RequestBody EmployeeDTO employee) {
        return employeeService.updateById(employeeId, employee);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Caching(evict = {
			@CacheEvict(value=CACHE_REGION, key = "'api_employees'"),
			@CacheEvict(value=CACHE_REGION, key = "'api_employees' + #id")})
	public EmployeeDTO delete(@PathParam("id") Integer employeeId) {
		return employeeService.delete(employeeId);
	}
	

	// http://localhost:8080/isp-platform/rest/employee/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public EmployeeResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return employeeService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public EmployeeResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return employeeService.find(null, page, maxItems);
	}
	
}
