package com.sd.isp.domain.report;

import java.util.Date;
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
import com.sd.isp.domain.entry_details.EntryDetailsDomain;

@Entity
@Table(name = "report")
public class ReportDomain extends BaseDomain {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@ManyToOne
	private EntryDomain _entry;

	@Column(name = "date", nullable = false)
	private Date _date;

	@Column(name = "observations", length = 10000)
	private String _observations;

	/********************************************************************************************/
	@ManyToOne
	private EntryDetailsDomain _details;

	@Column(name = "entryDetails")
	private String _entryDetails;

	/*@Column(name = "age")  
	private Integer _age;*/
	
	@Column(name = "isFinished")
	private Boolean _isFinished;

    /*********************************************************************************************/
	//@OneToOne
	//private EntryDetailsDomain _statistic;
	
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

	public String getObservations() {
		return _observations;
	}

	public void setObservations(String observations) {
		_observations = observations;
	}

	public EntryDetailsDomain getEntryDetails() {
		return _details;
	}

	public void setEntryDetails(EntryDetailsDomain details) {
		_details= details;
	}

	/*public Integer getAge() {
		return _age;
	}

	public void setAge(Integer age) {
		_age = age;
	}*/

	public Boolean getIsFinished() {
		return _isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		_isFinished = isFinished;
	}
	
   /*
	public EntryDetailsDomain getStatistic() {
		return _statistic;
	}

	public void setStatistic(EntryDetailsDomain statistic) {
		_statistic = statistic;
	}
	
	public String getEntryDetail(){
		return _entryDetail;
	}
	
	public void setEntryDetail(String diagnosticDetail){
		_entryDetail = diagnosticDetail;
	}*/
	
}
