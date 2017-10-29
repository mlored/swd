package com.sd.isp.domain.invoice_details;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetailsDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "quantity")
	private Integer _quantity;
	
	@Column(name = "price")
	private Integer _price;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		
	}
	
	
	public Integer getQuantity() {
		return _quantity;
	}

	public void setQuantity(Integer quantity) {
		_quantity = quantity;
	}

	public Integer getPrice() {
		return _price;
	}

	public void setPrice(Integer price) {
		_price = price;
	}
}
