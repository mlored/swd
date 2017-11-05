package com.sd.isp.domain.invoice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sd.isp.domain.base.BaseDomain;

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
	private Integer number;

	@Column(name = "type")
	private String type;
	
	@Column(name = "total")
	private Integer total;
	
	/*@OneToMany(mappedBy = "invoiceDomain")
    private List<InvoiceDetailsDomain> invoiceDetailsDomains;*/
	
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
		return total;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
