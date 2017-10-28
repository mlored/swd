package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.person.PersonDTO;
import com.sd.isp.dto.person.PersonResult;
import com.sd.isp.service.person.IPersonService;

@Path("/person")
@Component
public class PersonResource {

	@Autowired
	private IPersonService personService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public PersonDTO getById(@PathParam("id") Integer personId) {
		return personService.getById(personId);
	}

	@GET
	@Produces("application/xml")
	public PersonResult getAll() {
		return personService.getAll();
	}

	@POST
	public PersonDTO save(PersonDTO person) {
		return personService.save(person);
	}
}
