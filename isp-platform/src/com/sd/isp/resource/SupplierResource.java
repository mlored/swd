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

import com.sd.isp.dto.supplier.SupplierDTO;
import com.sd.isp.dto.supplier.SupplierResult;
import com.sd.isp.service.supplier.ISupplierService;

@Path("/supplier")
@Component
@Secured({"ROLE_SECRETARIO", "ROLE_ADMIN"})
public class SupplierResource extends BaseResource {

	@Autowired
	private ISupplierService supplierService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'api_suppliers' + #supplierId")
	public SupplierDTO getById(@PathParam("id") Integer supplierId) {
		return supplierService.getById(supplierId);
	}

	@GET
	@Produces("application/xml")
	@Cacheable(value=CACHE_REGION, key="'api_suppliers'")
	public SupplierResult getAll() {
		return supplierService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_suppliers'")
	@CachePut(value=CACHE_REGION, key="'api_suppliers' + #supplier.id")
	public SupplierDTO save(SupplierDTO supplier) {
		return supplierService.save(supplier);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'suppliers'")
	@CachePut(value=CACHE_REGION, key="'suppliers' + #id")
    public SupplierDTO updateById(@PathParam("id") Integer supplierId, @RequestBody SupplierDTO supplier) {
        return supplierService.updateById(supplierId, supplier);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMIN"})
	@Caching(evict = {
			@CacheEvict(value=CACHE_REGION, key = "'api_suppliers'"),
			@CacheEvict(value=CACHE_REGION, key = "'api_suppliers' + #id")})
	public SupplierDTO delete(@PathParam("id") Integer supplierId) {
		return supplierService.delete(supplierId);
	}


	// http://localhost:8080/isp-platform/rest/supplier/search/textToFind 
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public SupplierResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return supplierService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public SupplierResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws Exception {
		return supplierService.find(null, page, maxItems);
	}
}
