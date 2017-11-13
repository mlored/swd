package com.sd.isp.rest.employee;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("employeeResource")
public class EmployeeResourceImpl extends BaseResourceImpl<EmployeeDTO> implements IEmployeeResource {

	public EmployeeResourceImpl() {
		super(EmployeeDTO.class, "/employee");
	}

	@Override
	public EmployeeResult getAll() {
		final EmployeeResult result = getWebResource().get(EmployeeResult.class);
		return result;
	}

}
