package com.sd.isp.resource;


import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.isp.dto.support.SupportDTO;
import com.sd.isp.service.support.ISupportService;


@Path("/support")
@Component
public class SupportResource {

	@Autowired
	private ISupportService _supportService;
	
	@POST
	public SupportDTO save(SupportDTO support) {
		return _supportService.save(support);
	}
}
