package com.sd.isp.rest.employee;

import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IEmployeeResource extends IBaseResource<EmployeeDTO>{
    public EmployeeResult getAll();
    public EmployeeResult find(String textToFind, int maxItems, int page);
}
