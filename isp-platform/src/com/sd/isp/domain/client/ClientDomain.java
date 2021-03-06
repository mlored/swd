package com.sd.isp.domain.client;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.domain.entry.EntryDomain;

@Entity
public class ClientDomain extends PersonDomain {
	
	@OneToMany(mappedBy = "clientDomain")
    private List<EntryDomain> entryDomains;
	
	@OneToMany(mappedBy = "clientDomain")
	private List<BuyDomain> buyDomains;
	
}

