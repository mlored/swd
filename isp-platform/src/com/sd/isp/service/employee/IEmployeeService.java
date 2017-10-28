package com.sd.isp.service.employee;

import com.sd.isp.dao.employee.EmployeeDaoImpl;
import com.sd.isp.domain.employee.EmployeeDomain;
import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.service.base.IBaseService;

public interface IEmployeeService extends IBaseService<EmployeeDTO, EmployeeDomain, EmployeeDaoImpl, EmployeeResult> {

}
