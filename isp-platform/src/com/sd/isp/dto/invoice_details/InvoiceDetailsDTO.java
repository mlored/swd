package com.sd.isp.dto.invoice_details;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "invoice_details")
public class InvoiceDetailsDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _quantity;
	private Integer _price;
;

	@XmlElement
	public Date getQuantity() {
		return _quantity;
	}

	public void setQuantity(Date quantity) {
		_quantity = quantity;
	}


	@XmlElement
	public Integer getPrice() {
		return _price;
	}

	public void setPrice(Integer price) {
		_price = price;
	}

}
