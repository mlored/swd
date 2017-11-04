package com.sd.isp.dto.car;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "carResult")
public class CarResult extends BaseResult<CarDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CarDTO> getCars() {
		return getList();
	}

	public void setCars(List<CarDTO> dtos) {
		super.setList(dtos);
	}
}
