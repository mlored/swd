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

import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
import com.sd.isp.service.buy.IBuyService;

@Path("/buy")
@Component
@Secured({"ROLE_ADMIN","ROLE_SECRETARIO"})
public class BuyResource extends BaseResource{

	@Autowired
	private IBuyService buyService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Cacheable(value=CACHE_REGION, key="'buys' + #buy")
	public BuyDTO getById(@PathParam("id") Integer buy) {
		return buyService.getById(buy);
	}

	@GET
	@Produces("application/xml")
	@Cacheable(value=CACHE_REGION, key="'api_buys'")
	public BuyResult getAll() {
		return buyService.getAll();
	}

	@POST
	@CacheEvict(value=CACHE_REGION,key = "'api_buys'")
    @CachePut(value=CACHE_REGION, key="'api_buys' + #buy.id")
	public BuyDTO save(BuyDTO buy) {
		return buyService.save(buy);
	}
	
	@PUT
	@Path("/{id}")
	@CacheEvict(value=CACHE_REGION, key = "'api_buys'")
    @CachePut(value=CACHE_REGION, key="'api_buys' + #id")
    public BuyDTO updateById(@PathParam("id") Integer buyId, @RequestBody BuyDTO buy) {
        return buyService.updateById(buyId, buy);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	@Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'api_buys'"),
            @CacheEvict(value=CACHE_REGION, key = "'api_buys' + #id")})
	public BuyDTO delete(@PathParam("id") Integer buyId) {
		return buyService.delete(buyId);
	}
}
