package com.sd.isp.dto.location.city;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "cityResult")
public class CityResult extends BaseResult<CityDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CityDTO> getCities() {
		return getList();
	}

	public void setCities(List<CityDTO> dtos) {
		super.setList(dtos);
	}
}
