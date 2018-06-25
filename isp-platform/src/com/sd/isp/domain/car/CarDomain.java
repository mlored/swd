package com.sd.isp.domain.car;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.entry.EntryDomain;

@Entity
@Table(name = "cars")
public class CarDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "mark", nullable = false)
	private String mark;

	@Column(name = "model")
	private String model;

	@Column(name = "year")
	private Integer year;

	@Column(name = "color")
	private String color;
	
	@OneToMany(mappedBy = "carDomain")
    private List<EntryDomain> entryDomains;

	public List<EntryDomain> getEntryDomains() {
		return entryDomains;
	}

	public void setEntryDomains(List<EntryDomain> entryDomains) {
		this.entryDomains = entryDomains;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
