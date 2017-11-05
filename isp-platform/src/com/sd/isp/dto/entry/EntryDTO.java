package com.sd.isp.dto.entry;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "entry")
public class EntryDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _date;
	private Integer _number;
	private String _diagnostic;

	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	@XmlElement
	public Integer getNumber() {
		return _number;
	}

	public void setNumber(Integer number) {
		_number = number;
	}
	
	@XmlElement
	public String getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		_diagnostic = diagnostic;
	}
}