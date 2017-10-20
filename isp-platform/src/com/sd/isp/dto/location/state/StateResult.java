package com.sd.isp.dto.location.state;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "stateResult")
public class StateResult extends BaseResult<StateDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<StateDTO> getStates() {
		return getList();
	}

	public void setStates(List<StateDTO> dtos) {
		super.setList(dtos);
	}
}
