package com.sd.isp.beans.report;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.beans.report.ReportB;
import com.sd.isp.beans.entry_details.EntryDetailsB;

public class ReportB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private Date 		  _date;
	private EntryB		  _entry;
	private EntryDetailsB _entryDetail;
	private Boolean 	  _isFinished;
	
	//private DiagnosticB _diagnostic;
	//private String _entryDetail;
	//private String _observations;
	//private Integer _age;

	public ReportB(Map<String, String> params) {
		super(params);
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		//setObservations(params.get("observations"));
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public EntryB getEntry() {
		return _entry;
	}

	public void setEntry(EntryB entry) {
		_entry = entry;
	}
	
	public EntryDetailsB getEntryDetails() {
		return _entryDetail;
	}

	public void setEntryDetails(EntryDetailsB entryDetail) {
		_entryDetail = entryDetail;
	}
	
	public Boolean getIsFinished() {
		return _isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		_isFinished = isFinished;
	}
	
	/*public String getEntryDetail(){
		return _entryDetail;
	}
	
	public void setEntryDetail(String entryDetail){
		_entryDetail = entryDetail;
	}

	public String getObservations() {
		return _observations;
	}

	public void setObservations(String observations) {
		_observations = observations;
	}

	public Integer getAge() {
		return _age;
	}

	public void setAge(Integer age) {
		_age = age;
	}

	public StatisticB getStatistic() {
		return _statistic;
	}

	public void setStatistic(StatisticB statistic) {
		_statistic = statistic;
	}*/
}
