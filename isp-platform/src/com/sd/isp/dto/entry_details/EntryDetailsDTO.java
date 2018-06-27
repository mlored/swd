package com.sd.isp.dto.entry_details;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.item.ItemDTO;

@XmlRootElement(name = "entry_details")
public class EntryDetailsDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _date;
	private ItemDTO _item;
	private Integer _entryId;
	private Integer _itemId;


	public Integer getEntryId() {
		return _entryId;
	}

	public void setEntryId(Integer _entryId) {
		this._entryId = _entryId;
	}

	public ItemDTO getItem() {
		return _item;
	}

	public void setItem(ItemDTO item) {
		_item = item;
	}
	
	public Integer getItemId() {
		return _itemId;
	}

	public void setItemId(Integer itemId) {
		_itemId = itemId;
	}

	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}


}