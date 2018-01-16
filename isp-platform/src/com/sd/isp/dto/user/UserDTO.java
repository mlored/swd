package com.sd.isp.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	private String _userName;
	private String _name;
	private String _surName;
	private String _password;
	
	@XmlElement
	public String getUserName() {
		return _userName;
	}
	
	public void setUserName(String userName) {
		_userName = userName;
	}
	
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
	public String getPassword() {
		return _password;
	}
	
	public void setPassword(String password) {
		_password = password;
	}
	
}
