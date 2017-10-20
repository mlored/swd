package com.sd.isp.dto.location.country;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "countryResult")
public class CountryResult extends BaseResult<CountryDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CountryDTO> getCountries() {
		return getList();
	}

	public void setCountries(List<CountryDTO> dtos) {
		super.setList(dtos);
	}
}
