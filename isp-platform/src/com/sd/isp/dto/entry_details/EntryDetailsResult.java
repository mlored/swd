package com.sd.isp.dto.entry_details;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "entryDetailsResult")
public class EntryDetailsResult extends BaseResult<EntryDetailsDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EntryDetailsDTO> getEntryDetails() {
		return getList();
	}

	public void setEntryDetails(List<EntryDetailsDTO> dtos) {
		super.setList(dtos);
	}
}
