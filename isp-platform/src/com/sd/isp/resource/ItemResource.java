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

import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.dto.item.ItemDTO;
import com.sd.isp.dto.item.ItemResult;
import com.sd.isp.service.item.IItemService;

@Path("/item")
@Component
public class ItemResource {
	@Autowired
	private IItemService itemService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ItemDTO getById(@PathParam("id") Integer itemId) {
		return itemService.getById(itemId);
	}

	@GET
	@Produces("application/xml")
	public ItemResult getAll() {
		return itemService.getAll();
	}

	@POST
	public ItemDTO save(ItemDTO item) {
		return itemService.save(item);
	}
	
	@PUT
	@Path("/{id}")
    public ItemDTO updateById(@PathParam("id") Integer itemId, @RequestBody ItemDTO item) {
        return itemService.updateById(itemId, item);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public ItemDTO delete(@PathParam("id") Integer itemId) {
		return itemService.delete(itemId);
	}
	

	// http://localhost:8080/isp-platform/rest/item/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	//@Secured({"ROLE_ADMINISTRADOR"})
	public ItemResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return itemService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	//@Secured({"ROLE_ADMINISTRADOR"})
	public ItemResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return itemService.find(null, page, maxItems);
	}
}
