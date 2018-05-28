package com.sd.isp.dto.report;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "report")
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer  _entryId;
	private Integer  _entryDetailsId;
	private Date 	 _date;
	private String   _observations;
	//private Integer  _age;
	private Boolean  _isFinished;
	/*private Integer _statisticId;
	private String _diagnosticDetail;*/

	@XmlElement
	public Integer getEntryId() {
		return _entryId;
	}

	public void setEntryId(Integer entryId) {
		_entryId= entryId;
	}

	@XmlElement
	public Integer getEntryDetailsId() {
		return _entryDetailsId;
	}

	public void setEntryDetailsId(Integer entryDetails) {
		_entryDetailsId = entryDetails;
	}
/*	
	@XmlElement
	public String getDiagnosticDetail() {
		return _diagnosticDetail;
	}

	public void setDiagnosticDetail(String diagnosticDetail) {
		_diagnosticDetail = diagnosticDetail;
	}
	*/
	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	@XmlElement
	public String getObservations() {
		return _observations;
	}

	public void setObservations(String observations) {
		_observations = observations;
	}

	/*@XmlElement
	public Integer getAge() {
		return _age;
	}

	public void setAge(Integer age) {
		_age = age;
	}*/

	@XmlElement
	public Boolean getIsFinished() {
		return _isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		_isFinished = isFinished;
	}
	/*
	@XmlElement
	public Integer getStatisticId() {
		return _statisticId;
	}

	public void setStatisticId(Integer statisticId) {
		_statisticId = statisticId;
	}*/
}
