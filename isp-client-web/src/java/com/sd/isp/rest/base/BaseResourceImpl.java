package com.sd.isp.rest.base;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.car.CarResult;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

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
	public DTO save(DTO dto1) {
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();


		CarResult carResult = client.resource("http://localhost:8080/isp-platform/rest/car").get(CarResult.class);
		for (CarDTO c :carResult.getCars()) { System.out.println(c.getMark()); }

		CarDTO dto = new CarDTO();
		dto.setMark("Porsche");
		CarDTO newCar = client.resource("http://localhost:8080/isp-platform/rest/car").entity(dto).post(CarDTO.class);
		System.out.println(newCar.getMark());

		return null;
	}

	@Override
	public DTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

}
