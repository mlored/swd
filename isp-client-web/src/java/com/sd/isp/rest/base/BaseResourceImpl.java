package com.sd.isp.rest.base;

import com.sd.isp.dto.base.BaseDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private final WebResource _webResource;

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

	@Override
	public DTO save(DTO dto) {
		return getWebResource().entity(dto).post(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

}
