package com.sd.isp.domain.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;

@Entity
@Table(name = "report")
public class ReportDomain extends BaseDomain {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@ManyToOne       //@OneToOne
	private EntryDomain _entry;
	
	@ManyToOne       //@OneToOne
	private EntryDetailsDomain _entryDetails;

	@Column(name = "date", nullable = false)
	private Date _date;
	
	@Column(name = "isActived")
	private Boolean _isActived;


	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public EntryDomain getEntry() {
		return _entry;
	}

	public void setEntry(EntryDomain entry) {
		_entry = entry;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
	
	public Boolean getIsActived() {
		return _isActived;
	}

	public void setIsActived(Boolean isActived) {
		_isActived = isActived;
	}

	public EntryDetailsDomain getEntryDetails() {
		return _entryDetails;
	}

	public void setEntryDetails(EntryDetailsDomain details) {
		_entryDetails = details;
	}
	
}
