package com.sd.isp.beans.part;

import java.util.Map;

import com.sd.isp.beans.item.ItemB;
import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class PartB extends ItemB {
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private Integer _price;
	private Integer _quantity;

	public PartB(Map<String, String> params) {
		super(params);
	}
	
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String description) {
		_description = description;
	}
	
	public Integer getPrice() {
		return _price;
	}
	
	public void setPrice(Integer price) {
		_price = price;
	}
	
	public Integer getQuantity() {
		return _quantity;
	}
	
	public void setQuantity(Integer quantity) {
		_quantity = quantity;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setDescription(params.get("description"));
		if (!StringUtils.isBlank(params.get("price")))
			setPrice(Integer.valueOf(params.get("price")));
		if (!StringUtils.isBlank(params.get("price")))
			setQuantity(Integer.valueOf(params.get("quantity")));
	}
	
}
