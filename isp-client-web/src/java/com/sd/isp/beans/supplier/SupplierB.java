package com.sd.isp.beans.supplier;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class SupplierB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _surName;
	private String _ruc;
	private String _address;
	private String _cellphone;
	
	public SupplierB(Map<String, String> params) {
		super(params);
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
	public String getRuc() {
		return _ruc;
	}
	public void setRuc(String ruc) {
		_ruc = ruc;
	}
	public String getAddress() {
		return _address;
	}
	public void setAddress(String address) {
		_address = address;
	}
	public String getCellphone() {
		return _cellphone;
	}
	public void setCellphone(String cellphone) {
		_cellphone = cellphone;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setSurName(params.get("surName"));
		setRuc(params.get("RUC"));
		setAddress(params.get("address"));
		setCellphone(params.get("cellphone"));

	}

}
