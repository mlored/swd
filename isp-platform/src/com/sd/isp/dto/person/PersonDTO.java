package com.sd.isp.dto.person;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "person")
public class PersonDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _surName;
	private String _RUC;
	private Integer _cellphone;
	private String _address;

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
	public Integer getCellphone() {
		return _cellphone;
	}

	public void setCellphone(Integer cellphone) {
		_cellphone = cellphone;
	}
	
	@XmlElement
	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}
	

}
