package com.sd.isp.dto.buy;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "BuyResult")
public class BuyResult extends BaseResult<BuyDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<BuyDTO> getClients() {
		return getList();
	}

	public void setBuys(List<BuyDTO> dtos) {
		super.setList(dtos);
	}
}
