package com.sd.isp.dto.client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "client")
public class ClientDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _surName;
	private String _RUC;
	private String _cellphone;
	private String _address;
	private String _personType;

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String Name) {
		_name = Name;
	}

	@XmlElement
	public String getSurName() {
		return _surName;
	}

	public void setSurName(String surName) {
		_surName = surName;
	}

	@XmlElement
	public String getRUC() {
		return _RUC;
	}

	public void setRUC(String RUC) {
		_RUC = RUC;
	}

	@XmlElement
	public String getCellphone() {
		return _cellphone;
	}

	public void setCellphone(String cellphone) {
		_cellphone = cellphone;
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

	public void setType(String personType) {
		_personType = personType;
	}

}
