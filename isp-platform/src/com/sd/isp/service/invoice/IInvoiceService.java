package com.sd.isp.service.invoice;

import com.sd.isp.dao.invoice.InvoiceDaoImpl;
import com.sd.isp.domain.invoice.InvoiceDomain;
import com.sd.isp.dto.invoice.InvoiceDTO;
import com.sd.isp.dto.invoice.InvoiceResult;
import com.sd.isp.service.base.IBaseService;

public interface IInvoiceService extends IBaseService<InvoiceDTO, InvoiceDomain, InvoiceDaoImpl, InvoiceResult> {

}
