package com.sd.isp.dto.entry_details;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.car.CarDTO;
import com.sd.isp.dto.part.PartDTO;

@XmlRootElement(name = "entry_details")
public class EntryDetailsDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _date;
	private PartDTO _part;
	private Integer _entryId;


	public Integer getEntryId() {
		return _entryId;
	}

	public void setEntryId(Integer _entryId) {
		this._entryId = _entryId;
	}

	public PartDTO getPart() {
		return _part;
	}

	public void setPart(PartDTO part) {
		_part = part;
	}

	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}


}