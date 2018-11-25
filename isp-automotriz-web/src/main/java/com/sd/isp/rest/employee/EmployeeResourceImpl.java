package com.sd.isp.rest.employee;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.rest.base.BaseResourceImpl;
@Repository("employeeResource")
public class EmployeeResourceImpl extends BaseResourceImpl<EmployeeDTO, EmployeeResult> implements IEmployeeResource {

    public EmployeeResourceImpl() {
        super(EmployeeDTO.class, "/employee", EmployeeResult.class);
    }

    @Override
    public EmployeeResult getAll() {
        return super.getAll();
    }

    @Override
    public EmployeeResult find(String textToFind, int maxItems, int page) {
        //setWebResourceBasicAuthFilter();
        final EmployeeResult result = findWR(textToFind, maxItems, page);
        return result;
    }

}
