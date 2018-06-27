package com.sd.isp.dto.item;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;
import com.sd.isp.dto.item.ItemDTO;

@XmlRootElement(name = "itemResult")
public class ItemResult extends BaseResult<ItemDTO> {
	
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ItemDTO> getItems() {
		return getList();
	}

	public void setItems(List<ItemDTO> dtos) {
		super.setList(dtos);
	}
}
