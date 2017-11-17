package com.sd.isp.dto.part;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "part")
public class PartDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private String _price;
	private String _quantity;

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
	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		_price = price;
	}

	@XmlElement
	public String getQuantity() {
		return _quantity;
	}

	public void setQuantity(String quantity) {
		_quantity = quantity;
	}

}
