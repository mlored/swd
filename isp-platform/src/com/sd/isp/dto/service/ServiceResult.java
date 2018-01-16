package com.sd.isp.dto.service;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;
import com.sd.isp.dto.service.ServiceDTO;

@XmlRootElement(name = "serviceResult")
public class ServiceResult extends BaseResult<ServiceDTO> {
	
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ServiceDTO> getServices() {
		return getList();
	}

	public void setServices(List<ServiceDTO> dtos) {
		super.setList(dtos);
	}
}
