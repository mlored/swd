package com.sd.isp.domain.entry;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.car.CarDomain;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;

@Entity
@Table(name = "entries")
public class EntryDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "diagnostic", nullable = false)
	private String diagnostic;

	@Column(name = "number", unique = true, nullable = false)
	private Integer number;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CarDomain carDomain;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ClientDomain clientDomain;

	
	@OneToMany(mappedBy = "entryDomain")
    private List<EntryDetailsDomain> entryDetailsDomains;
	
	public List<EntryDetailsDomain> getEntryDetailsDomains() {
		return entryDetailsDomains;
	}

	public void setEntryDetailsDomains(List<EntryDetailsDomain> entryDetailsDomains) {
		this.entryDetailsDomains = entryDetailsDomains;
	}

	public CarDomain getCarDomain() {
		return carDomain;
	}

	public void setCarDomain(CarDomain carDomain) {
		this.carDomain = carDomain;
	}

	public ClientDomain getClientDomain() {
		return clientDomain;
	}

	public void setClientDomain(ClientDomain clientDomain) {
		this.clientDomain = clientDomain;
	}

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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	
	
}
