package com.sd.isp.dto.invoice_details;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "invoiceDetailsResult")
public class InvoiceDetailsResult extends BaseResult<InvoiceDetailsDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<InvoiceDetailsDTO> getInvoiceDetails() {
		return getList();
	}

	public void setInvoiceDetails(List<InvoiceDetailsDTO> dtos) {
		super.setList(dtos);
	}
}
