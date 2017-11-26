package com.sd.isp.service.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.employee.EmployeeB;
import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.rest.employee.IEmployeeResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeB, EmployeeDTO>
		implements IEmployeeService {

	@Autowired
	private IEmployeeResource _employeeResource;


	public EmployeeServiceImpl() {
	}

	@Override
	public EmployeeB save(EmployeeB bean) {
		final EmployeeDTO employee = convertBeanToDto(bean);
		final EmployeeDTO dto = _employeeResource.save(employee);
		final EmployeeB employeeB = convertDtoToBean(dto);
		return employeeB;
	}

	@Override
	public List<EmployeeB> getAll() {
		final EmployeeResult result = _employeeResource.getAll();
		final List<EmployeeDTO> cList = null == result.getEmployees() ? new ArrayList<EmployeeDTO>()
				: result.getEmployees();

		final List<EmployeeB> employees = new ArrayList<EmployeeB>();
		for (EmployeeDTO dto : cList) {
			final EmployeeB bean = convertDtoToBean(dto);
			employees.add(bean);
		}
		return employees;
	}

	@Override
	public EmployeeB getById(Integer id) {
		final EmployeeDTO dto = _employeeResource.getById(id);
		final EmployeeB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	public EmployeeB delete(Integer id) {
		final EmployeeDTO dto = _employeeResource.destroy(id);
        final EmployeeB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected EmployeeB convertDtoToBean(EmployeeDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("surName", dto.getSurName());
		params.put("ruc", dto.getRuc());
		params.put("address", dto.getAddress());
		params.put("cellphone", dto.getCellphone());

		final EmployeeB employeeB = new EmployeeB(params);

		return employeeB;
	}

	@Override
	protected EmployeeDTO convertBeanToDto(EmployeeB bean) {
		final EmployeeDTO dto = new EmployeeDTO();
		dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setSurName(bean.getSurName());
        dto.setRuc(bean.getRuc());
        dto.setAddress(bean.getAddress());
        dto.setCellphone(bean.getCellphone());
		return dto;
	}

	@Override
	public EmployeeB update(Integer id, EmployeeB bean) {
		// TODO Auto-generated method stub
		return null;
	}
}
