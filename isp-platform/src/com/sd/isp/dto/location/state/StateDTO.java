package com.sd.isp.dto.location.state;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "state")
public class StateDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _countryId;
	private String _name;

	@XmlElement
	public Integer getCountryId() {
		return _countryId;
	}

	public void setCountryId(Integer countryId) {
		_countryId = countryId;
	}

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

}
