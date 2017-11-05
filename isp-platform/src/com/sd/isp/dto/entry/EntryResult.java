package com.sd.isp.dto.entry;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "entryResult")
public class EntryResult extends BaseResult<EntryDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EntryDTO> getEntry() {
		return getList();
	}

	public void setEntry(List<EntryDTO> dtos) {
		super.setList(dtos);
	}
}