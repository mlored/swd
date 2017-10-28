package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
