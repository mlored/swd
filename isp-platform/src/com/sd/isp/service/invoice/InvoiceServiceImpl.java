package com.sd.isp.service.invoice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.invoice.InvoiceDaoImpl;
import com.sd.isp.dao.invoice.IInvoiceDao;
import com.sd.isp.domain.invoice.InvoiceDomain;
import com.sd.isp.dto.invoice.InvoiceDTO;
import com.sd.isp.dto.invoice.InvoiceResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class InvoiceServiceImpl extends BaseServiceImpl<InvoiceDTO, InvoiceDomain, InvoiceDaoImpl, InvoiceResult> implements IInvoiceService {

	@Autowired
	private IInvoiceDao invoiceDao;

	@Override
	@Transactional
	public InvoiceDTO save(InvoiceDTO dto) {
		final InvoiceDomain invoiceDomain = convertDtoToDomain(dto);
		final InvoiceDomain invoice = invoiceDao.save(invoiceDomain);
		return convertDomainToDto(invoice);
	}

	@Override
	@Transactional
	public InvoiceDTO getById(Integer id) {
		final InvoiceDomain invoiceDomain = invoiceDao.getById(id);
		final InvoiceDTO invoiceDTO = convertDomainToDto(invoiceDomain);
		return invoiceDTO;
	}

	@Override
	@Transactional
	public InvoiceResult getAll() {
		final List<InvoiceDTO> invoices = new ArrayList<>();
		for (InvoiceDomain domain : invoiceDao.findAll()) {
			final InvoiceDTO invoice = convertDomainToDto(domain);
			invoices.add(invoice);
		}

		final InvoiceResult invoicesResult = new InvoiceResult();
		invoicesResult.setInvoices(invoices);
		return invoicesResult;
	}
	
	@Override
	public InvoiceDTO updateById(Integer id, InvoiceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InvoiceDTO convertDomainToDto(InvoiceDomain domain) {
		final InvoiceDTO invoice = new InvoiceDTO();
		invoice.setId(domain.getId());
		invoice.setDate(domain.getDate());
		invoice.setNumber(domain.getNumber());
		invoice.setTotal(domain.getTotal());
		invoice.setType(domain.getType());
		return invoice;
	}

	@Override
	protected InvoiceDomain convertDtoToDomain(InvoiceDTO dto) {
		final InvoiceDomain invoice = new InvoiceDomain();
		invoice.setId(dto.getId());
		invoice.setDate(dto.getDate());
		invoice.setNumber(dto.getNumber());
		invoice.setTotal(dto.getTotal());
		invoice.setType(dto.getType());
		return invoice;
	}

}
