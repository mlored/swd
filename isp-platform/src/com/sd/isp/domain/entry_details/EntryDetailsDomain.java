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
import com.sd.isp.domain.item.ItemDomain;

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

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public ItemDomain getItemDomain() {
			return itemDomain;
		}

		public void setItemDomain(ItemDomain itemDomain) {
			this.itemDomain = itemDomain;
		}

		public EntryDomain getEntryDomain() {
			return entryDomain;
		}

		public void setEntryDomain(EntryDomain entryDomain) {
			this.entryDomain = entryDomain;
		}

}
