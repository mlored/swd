package com.sd.isp.beans.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.role.RoleB;

public class UserB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String _username;
	private String _name;
	private String _surName;
	private String _password;
	private RoleB _role;
	private String _accountExpired;
	private String _accountLocked;
	private String _passwordExpired;
	private List<RoleB> _roles = new ArrayList<RoleB>();

	public List<RoleB> getRoles(){
		return _roles;
	}

	public void setRoles(List<RoleB> roles){
		_roles = roles;
	}
	
	public UserB(Map<String, String> params) {
		super(params);
	}
	
	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSurName() {
		return _surName;
	}

	public void setSurName(String surName) {
		_surName = surName;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public RoleB getRole() {
		return _role;
	}

	public void setRole(RoleB role) {
		_role = role;
	}

	public String getAccountLocked() {
		return _accountLocked;
	}

	public void setAccountLocked(String accountLocked) {
		_accountLocked = accountLocked;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setUsername(params.get("username"));
		setName(params.get("name"));
		setSurName(params.get("surName"));
		setPassword(params.get("password"));
		setAccountLocked(params.get("accountLocked"));
	}

}
