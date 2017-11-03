package com.sd.isp.dto.sell;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "SellResult")
public class SellResult extends BaseResult<SellDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<SellDTO> getClients() {
		return getList();
	}

	public void setSells(List<SellDTO> dtos) {
		super.setList(dtos);
	}
}
