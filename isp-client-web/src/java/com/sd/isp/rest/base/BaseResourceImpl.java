package com.sd.isp.rest.base;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.base.BaseResult;
import com.sd.isp.service.auth.IAuthService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseResourceImpl<DTO extends BaseDTO, Result extends BaseResult> implements IBaseResource<DTO, Result> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private Class<Result> _resultClass;
	private final WebResource _webResource;
	
	@Autowired
	private IAuthService authService;
	
	private static final String BASE_URL = "http://localhost:81/isp-platform/rest";

	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;

		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);
	}

	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath, Class<Result> resultClass) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;
		_resultClass = resultClass;


		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);

		setWebResourceBasicAuthFilter();
	}

	protected WebResource getWebResource() {
		return _webResource;
	}

	protected Class<DTO> getDtoClass() {
		return _dtoClass;
	}

	protected Class<Result> getResultClass() {
		return _resultClass;
	}

	private void setWebResourceBasicAuthFilter(){
		String u = "mlored"; //authService.getUsername();
		String p = "12345678"; //authService.getPassword();
				
		_webResource.addFilter(new HTTPBasicAuthFilter(u,p));		
	}

	@Override
	public Result getAll(){
		setWebResourceBasicAuthFilter();

		return getWebResource().get(getResultClass());
	}

	@Override
	public DTO save(DTO dto) {
		setWebResourceBasicAuthFilter();
		return getWebResource().header("username","mlored").header("password","12345678").entity(dto).post(getDtoClass());
	}

	@Override
	public DTO update(Integer id, DTO dto) {
		setWebResourceBasicAuthFilter();
		return getWebResource().path("/" + id).header("username","mlored").header("password","12345678").entity(dto).put(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		setWebResourceBasicAuthFilter();

		return getWebResource().path("/" + id).get(getDtoClass());
	}

	@Override
	public DTO destroy(Integer id){
		setWebResourceBasicAuthFilter();
		return getWebResource().path("/" + id).delete(getDtoClass());
	}

	public Result findWR(String textToFind, int maxItems, int page) {
		Result result;
		if (null == textToFind){
			setWebResourceBasicAuthFilter();
			result = getWebResource().path("/search/" + maxItems + "/" + page).get(getResultClass());
		}else{
			setWebResourceBasicAuthFilter();
			result =  getWebResource().path("/search/" + maxItems + "/" + page + "/" + textToFind).get(getResultClass());
		}
		return result;
	}
}
