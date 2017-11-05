package com.sd.isp.domain.buy;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.domain.invoice.InvoiceDomain;

@Entity
public class BuyDomain extends InvoiceDomain {
	
@ManyToOne
private ClientDomain clientDomain;
}
