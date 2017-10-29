package com.sd.isp.dto.invoice;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "invoiceResult")
public class InvoiceResult extends BaseResult<InvoiceDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<InvoiceDTO> getClients() {
		return getList();
	}

	public void setInvoices(List<InvoiceDTO> dtos) {
		super.setList(dtos);
	}
}
