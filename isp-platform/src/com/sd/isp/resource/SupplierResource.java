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

import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.service.supplier.ISupplierService;

@Path("/supplier")
@Component
public class SupplierResource {

	@Autowired
	private ISupplierService supplierService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public SupplierDTO getById(@PathParam("id") Integer supplierId) {
		return supplierService.getById(supplierId);
	}

	@GET
	@Produces("application/xml")
	public SupplierResult getAll() {
		return supplierService.getAll();
	}

	@POST
	public SupplierDTO save(SupplierDTO supplier) {
		return supplierService.save(supplier);
	}
	
	@PUT
	@Path("/{id}")
    public SupplierDTO updateById(@PathParam("id") Integer supplierId, @RequestBody SupplierDTO supplier) {
        return supplierService.updateById(supplierId, supplier);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public SupplierDTO delete(@PathParam("id") Integer supplierId) {
		return supplierService.delete(supplierId);
	}


	// http://localhost:8080/isp-platform/rest/client/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	//@Secured({"ROLE_ADMINISTRADOR"})
	public SupplierResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return supplierService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	//@Secured({"ROLE_ADMINISTRADOR"})
	public SupplierResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return supplierService.find(null, page, maxItems);
	}
}
