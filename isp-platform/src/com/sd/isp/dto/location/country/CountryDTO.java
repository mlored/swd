package com.sd.isp.dto.location.country;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "country")
public class CountryDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

}
