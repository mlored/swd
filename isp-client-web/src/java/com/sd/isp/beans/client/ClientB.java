package com.sd.isp.beans.client;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.city.CityB;

public class ClientB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _firstName;
	private String _lastName;
	private String _document;
	private CityB _city;

	public ClientB(Map<String, String> params) {
		super(params);
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getDocument() {
		return _document;
	}

	public void setDocument(String document) {
		_document = document;
	}

	public CityB getCity() {
		return _city;
	}

	public void setCity(CityB city) {
		_city = city;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setFirstName(params.get("firstName"));
		setLastName(params.get("lastName"));
		setDocument(params.get("document"));

	}

}
