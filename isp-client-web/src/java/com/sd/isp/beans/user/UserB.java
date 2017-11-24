package com.sd.isp.beans.user;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.role.RoleB;

public class UserB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String _userName;
	private String _name;
	private String _surName;
	private String _password;
	private RoleB _role;
	private String _accountLocked;
	
	public UserB(Map<String, String> params) {
		super(params);
	}
	
	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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
		setUserName(params.get("userName"));
		setName(params.get("name"));
		setSurName(params.get("surName"));
		setPassword(params.get("password"));
		setAccountLocked(params.get("accountLocked"));

	}

}
