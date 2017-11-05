package com.sd.isp.dto.entry_details;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "entry_details")
public class EntryDetailsDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _date;
;

	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}


}