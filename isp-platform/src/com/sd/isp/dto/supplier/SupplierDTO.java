package com.sd.isp.dto.supplier;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "supplier")
public class SupplierDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _surName;
	private String _ruc;
	private String _address;
	private String _personType;
	private Integer _cellphone;

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@XmlElement
	public String getSurName() {
		return _surName;
	}

	public void setSurName(String surName) {
		_surName = surName;
	}

	@XmlElement
	public String getRuc() {
		return _ruc;
	}

	public void setRuc(String ruc) {
		_ruc = ruc;
	}
	
	@XmlElement
	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}
	
	@XmlElement
	public String getType() {
		return _personType;
	}

	public void setType(String type) {
		_personType = type;
	}

	@XmlElement
	public Integer getCellphone() {
		return _cellphone;
	}

	public void setCellphone(Integer cellphone) {
		_cellphone = cellphone;
	}

}
