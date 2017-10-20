package com.sd.isp.dto.client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "client")
public class ClientDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _firstName;
	private String _lastName;
	private String _document;
	private Integer _cityId;

	@XmlElement
	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@XmlElement
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@XmlElement
	public String getDocument() {
		return _document;
	}

	public void setDocument(String document) {
		_document = document;
	}

	@XmlElement
	public Integer getCityId() {
		return _cityId;
	}

	public void setCityId(Integer cityId) {
		_cityId = cityId;
	}

}
