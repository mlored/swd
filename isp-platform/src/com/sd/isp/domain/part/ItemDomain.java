package com.sd.isp.domain.part;

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
public abstract class ItemDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "price")
	private String price;

	@Column(name = "quantity", nullable = true)
	private String quantity;
	
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}