package com.sd.isp.domain.item;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;
import com.sd.isp.domain.invoice_details.InvoiceDetailsDomain;

@Entity
@Table(name = "items")
public class ItemDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "quantity", nullable = true)
	private Integer quantity;
	
	@OneToMany(mappedBy = "itemDomain")
    private List<EntryDetailsDomain> entryDetailsDomains;
	
	@OneToMany(mappedBy = "itemDomain")
    private List<InvoiceDetailsDomain> invoiceDetailsDomains;
	

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}