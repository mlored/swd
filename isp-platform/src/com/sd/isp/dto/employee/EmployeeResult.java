package com.sd.isp.dto.employee;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;

@XmlRootElement(name = "employeeResult")
public class EmployeeResult extends BaseResult<EmployeeDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EmployeeDTO> getEmployees() {
		return getList();
	}

	public void setEmployees(List<EmployeeDTO> dtos) {
		super.setList(dtos);
	}
}
