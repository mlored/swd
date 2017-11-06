package com.sd.isp.domain.entry_details;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.domain.part.ItemDomain;

@Entity
@Table(name = "entry_details")
public class EntryDetailsDomain extends BaseDomain {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id", nullable = false, unique = true)
		private Integer id;

		@Column(name = "date")
		private Date date;
		
		@ManyToOne
	    private ItemDomain itemDomain;
		
		@ManyToOne
	    private EntryDomain entryDomain;

}
