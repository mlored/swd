package com.sd.isp.dto.part;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;
import com.sd.isp.dto.part.PartDTO;

@XmlRootElement(name = "partResult")
public class PartResult extends BaseResult<PartDTO> {
	
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PartDTO> getParts() {
		return getList();
	}

	public void setParts(List<PartDTO> dtos) {
		super.setList(dtos);
	}
}
