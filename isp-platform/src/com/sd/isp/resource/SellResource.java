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

import com.sd.isp.dto.sell.SellDTO;
import com.sd.isp.dto.sell.SellResult;
import com.sd.isp.service.sell.ISellService;

@Path("/sell")
@Component
public class SellResource {

	@Autowired
	private ISellService sellService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public SellDTO getById(@PathParam("id") Integer sell) {
		return sellService.getById(sell);
	}

	@GET
	@Produces("application/xml")
	public SellResult getAll() {
		return sellService.getAll();
	}

	@POST
	public SellDTO save(SellDTO sell) {
		return sellService.save(sell);
	}
	
	@PUT
	@Path("/{id}")
    public SellDTO updateById(@PathParam("id") Integer sellId, @RequestBody SellDTO sell) {
        return sellService.updateById(sellId, sell);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public SellDTO delete(@PathParam("id") Integer sellId) {
		return sellService.delete(sellId);
	}
}
