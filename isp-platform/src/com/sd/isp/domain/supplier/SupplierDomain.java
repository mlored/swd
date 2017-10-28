package com.sd.isp.domain.supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;

@Entity
@Table(name = "supplier")
public class SupplierDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surName")
	private String surName;

	@Column(name = "ruc", unique = true)
	private String ruc;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "type")
	private String type;

	@Column(name = "cellphone")
	private Integer _cellphone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCellphone() {
		return _cellphone;
	}

	public void setCellphone(Integer cellphone) {
		_cellphone = cellphone;
	}
}
