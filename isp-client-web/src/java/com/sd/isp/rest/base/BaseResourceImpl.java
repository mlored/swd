package com.sd.isp.rest.base;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.service.auth.IAuthService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private final WebResource _webResource;
	
	@Autowired
	private IAuthService authService;
	
	private static final String BASE_URL = "http://localhost:8080/isp-platform/rest";

	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;

		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);
	}

	protected WebResource getWebResource() {
		return _webResource;
	}

	protected Class<DTO> getDtoClass() {
		return _dtoClass;
	}
/*	
	public void setWebResourceBasicAuthFilter(){
		String u = authService.getUsername();
		String p = authService.getPassword();
				
		_webResource.addFilter(new HTTPBasicAuthFilter(u,p));		
	}
*/
	@Override
	public DTO save(DTO dto) {
		return getWebResource().entity(dto).post(getDtoClass());
	}

	@Override
	public DTO update(Integer id, DTO dto) {
		return getWebResource().path("/" + id).entity(dto).put(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

	@Override
	public DTO destroy(Integer id){
		return getWebResource().path("/" + id).delete(getDtoClass());
	}
}
