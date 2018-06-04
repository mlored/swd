package com.sd.isp.dto.report;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "report")
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer  _entryId;
	//private Integer  _entryDetailsId;
	private Date 	 _date;
	private Boolean  _isFinished;

	@XmlElement
	public Integer getEntryId() {
		return _entryId;
	}

	public void setEntryId(Integer entryId) {
		_entryId= entryId;
	}

	/*@XmlElement
	public Integer getEntryDetailsId() {
		return _entryDetailsId;
	}

	public void setEntryDetailsId(Integer entryDetails) {
		_entryDetailsId = entryDetails;
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
	public Boolean getIsFinished() {
		return _isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		_isFinished = isFinished;
	}

}
