package com.sd.isp.domain.invoice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.client.ClientDomain;

@Entity
@Table(name = "invoice")
public class InvoiceDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "date")
	private Date date;
	
	@Column(name = "number")
	private Integer _number;

	@Column(name = "type")
	private String type;
	
	@Column(name = "total")
	private Integer _total;
	
	
	@ManyToOne
	private ClientDomain _client;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getNumber() {
		return _total;
	}

	public void setNumber(Integer number) {
		_total = number;
	}

	public Integer getTotal() {
		return _total;
	}

	public void setTotal(Integer total) {
		_total = total;
	}
}
