package com.sd.isp.domain.person;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;

@Entity
@Table(name = "person")
public class PersonDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surName")
	private String surName;

	@Column(name = "RUC", unique = true)
	private String RUC;

	@Column(name = "cellphone")
	private Integer cellphone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "type")
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String ruc) {
		this.RUC = ruc;
	}

	public Integer getCellphone() {
		return cellphone;
	}

	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
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
}

