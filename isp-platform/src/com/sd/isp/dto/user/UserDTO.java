package com.sd.isp.dto.user;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.role.RoleDTO;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	private String _username;
	private String _name;
	private String _surName;
	private String _password;
	private String _accountExpired;
	private String _accountLocked;
	private String _passwordExpired;
	private Integer _rolId;
	private List<RoleDTO> _roles = new ArrayList<RoleDTO>();
	
	@XmlElement
	public List<RoleDTO> getRoles() {
		return _roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		_roles = roles;
	}
	
	@XmlElement
	public Integer getRolId() {
		return _rolId;
	}
	
	public void setRolId(Integer rolId) {
		_rolId = rolId;
	}
	
	@XmlElement
	public String getUsername() {
		return _username;
	}
	
	public void setUsername(String username) {
		_username = username;
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
	
	@XmlElement
	public String getAccountExpired() {
		return _accountExpired;
	}

	public void setAccountExpired(String _accountExpired) {
		this._accountExpired = _accountExpired;
	}

	@XmlElement
	public String getAccountLocked() {
		return _accountLocked;
	}

	public void setAccountLocked(String _accountLocked) {
		this._accountLocked = _accountLocked;
	}
	
	@XmlElement
	public String getPasswordExpired() {
		return _passwordExpired;
	}

	public void setPasswordExpired(String _passwordExpired) {
		this._passwordExpired = _passwordExpired;
	}
	
}
