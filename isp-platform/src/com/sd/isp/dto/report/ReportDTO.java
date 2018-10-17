package com.sd.isp.dto.report;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "report")
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer  _entryId;
	private Date 	 _date;
	private Boolean  _isActived; 
    private Integer  _entryDetailsId;

	@XmlElement
	public Integer getEmployeeId() {
		return _entryId;
	}

	public void setEmployeeId(Integer employeeId) {
		_entryId= employeeId;
	}


	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
	
	@XmlElement
	public Boolean getIsActived() {
		return _isActived;
	}

	public void setIsActived(Boolean isActived) {
		_isActived = isActived;
	}
	
	@XmlElement
	public Integer getEntryDetailsId() {
		return _entryDetailsId;
	}

	public void setEntryDetailsId(Integer entryDetails) {
		_entryDetailsId = entryDetails;
	}
	

}
