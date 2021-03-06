package com.sd.isp.domain.client;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;

@Entity
@Table(name = "person")
public abstract class PersonDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname", nullable = true)
	private String surname;

	@Column(name = "RUC", unique = true)
	private String RUC;

	@Column(name = "cellphone" ,nullable = true)
	private String cellphone;
	
	@Column(name = "address" ,nullable = true)
	private String address;
	

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
		return surname;
	}

	public void setSurName(String surname) {
		this.surname = surname;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String ruc) {
		this.RUC = ruc;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}

