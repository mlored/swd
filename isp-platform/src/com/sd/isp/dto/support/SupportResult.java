package com.sd.isp.dto.support;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "supportResult")
public class SupportResult extends BaseResult<SupportDTO>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<SupportDTO> getSupports() {
		return getList();
	}

	public void setSupports(List<SupportDTO> dtos) {
		super.setList(dtos);
	}

}
