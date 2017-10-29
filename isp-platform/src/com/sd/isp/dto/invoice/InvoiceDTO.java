package com.sd.isp.dto.invoice;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "invoice")
public class InvoiceDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _date;
	private Integer _number;
	private Integer _total;
	private String _type;

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
	public Integer getTotal() {
		return _total;
	}

	public void setTotal(Integer total) {
		_total = total;
	}

	
	@XmlElement
	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}
}
