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

import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.service.employee.IEmployeeService;

@Path("/employee")
@Component
public class EmployeeResource {

	@Autowired
	private IEmployeeService employeeService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public EmployeeDTO getById(@PathParam("id") Integer employeeId) {
		return employeeService.getById(employeeId);
	}

	@GET
	@Produces("application/xml")
	public EmployeeResult getAll() {
		return employeeService.getAll();
	}

	@POST
	public EmployeeDTO save(EmployeeDTO employee) {
		return employeeService.save(employee);
	}
	
	@PUT
	@Path("/{id}")
    public EmployeeDTO updateById(@PathParam("id") Integer employeeId, @RequestBody EmployeeDTO employee) {
        return employeeService.updateById(employeeId, employee);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public EmployeeDTO delete(@PathParam("id") Integer employeeId) {
		return employeeService.delete(employeeId);
	}
	

	// http://localhost:8080/isp-platform/rest/employee/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	//@Secured({"ROLE_ADMINISTRADOR"})
	public EmployeeResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return employeeService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	//@Secured({"ROLE_ADMINISTRADOR"})
	public EmployeeResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return employeeService.find(null, page, maxItems);
	}
	
}
