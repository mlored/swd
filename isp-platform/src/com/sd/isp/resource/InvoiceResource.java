package com.sd.isp.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.isp.dto.invoice.InvoiceDTO;
import com.sd.isp.dto.invoice.InvoiceResult;
import com.sd.isp.service.invoice.IInvoiceService;

@Path("/invoice")
@Component
public class InvoiceResource {

	@Autowired
	private IInvoiceService invoiceService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public InvoiceDTO getById(@PathParam("id") Integer invoice) {
		return invoiceService.getById(invoice);
	}

	@GET
	@Produces("application/xml")
	public InvoiceResult getAll() {
		return invoiceService.getAll();
	}

	@POST
	public InvoiceDTO save(InvoiceDTO invoice) {
		return invoiceService.save(invoice);
	}
	
	@PUT
	@Path("/{id}")
    public InvoiceDTO updateById(@PathParam("id") Integer invoiceId, @RequestBody InvoiceDTO invoice) {
        return invoiceService.updateById(invoiceId, invoice);
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public InvoiceDTO delete(@PathParam("id") Integer invoiceId) {
		return invoiceService.delete(invoiceId);
	}
}
