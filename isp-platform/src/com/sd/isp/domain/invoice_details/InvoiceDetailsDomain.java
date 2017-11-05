package com.sd.isp.domain.invoice_details;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.invoice.InvoiceDomain;
import com.sd.isp.domain.item.ItemDomain;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetailsDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Integer price;
	
	@ManyToOne
	private InvoiceDomain invoiceDomain;
	
	@ManyToOne
	private ItemDomain itemDomain;
			
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
