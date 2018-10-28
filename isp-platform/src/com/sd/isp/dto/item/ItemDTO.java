package com.sd.isp.dto.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "item")
public class ItemDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String  _name;
	private String  _description;
	private Integer _price;
	private Integer _quantity;

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@XmlElement
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	@XmlElement
	public Integer getPrice() {
		return _price;
	}

	public void setPrice(Integer price) {
		_price = price;
	}

	@XmlElement
	public Integer getQuantity() {
		return _quantity;
	}

	public void setQuantity(Integer quantity) {
		_quantity = quantity;
	}

}
