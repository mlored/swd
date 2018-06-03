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

	
	/*@ManyToOne
	private EntryDetailsDomain _entrydetails;
	*/
	@ManyToOne
	private EntryDomain _entry;

	@Column(name = "date", nullable = false)
	private Date _date;
	
	@Column(name = "isFinished")
	private Boolean _isFinished;


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
	
	public Boolean getIsFinished() {
		return _isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		_isFinished = isFinished;
	}

	/*public EntryDetailsDomain getEntryDetails() {
		return _entrydetails;
	}

	public void setEntryDetails(EntryDetailsDomain details) {
		_entrydetails= details;
	}*/


	
}
