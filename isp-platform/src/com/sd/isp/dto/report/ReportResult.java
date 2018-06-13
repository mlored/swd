package com.sd.isp.dto.report;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "reportResult")

public class ReportResult extends BaseResult<ReportDTO>{

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<ReportDTO> getReports() {
		return getList();
	}

	public void setReports(List<ReportDTO> dtos) {
		super.setList(dtos);
	}
	
}
