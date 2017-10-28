package com.sd.isp.dto.person;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "personResult")
public class PersonResult extends BaseResult<PersonDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PersonDTO> getPersons() {
		return getList();
	}

	public void setPersons(List<PersonDTO> dtos) {
		super.setList(dtos);
	}
}
