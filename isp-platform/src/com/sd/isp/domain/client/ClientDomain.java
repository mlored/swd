package com.sd.isp.domain.client;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.domain.person.PersonDomain;

@Entity
public class ClientDomain extends PersonDomain {
	
	@OneToMany(mappedBy = "clientDomain")
    private List<EntryDomain> entryDomains;
	
}

