package com.sd.isp.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.employee.EmployeeDaoImpl;
import com.sd.isp.dao.employee.IEmployeeDao;
import com.sd.isp.domain.employee.EmployeeDomain;
import com.sd.isp.dto.employee.EmployeeDTO;
import com.sd.isp.dto.employee.EmployeeResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeDTO, EmployeeDomain, EmployeeDaoImpl, EmployeeResult> implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	@Transactional
	public EmployeeDTO save(EmployeeDTO dto) {
		final EmployeeDomain employeeDomain = convertDtoToDomain(dto);
		final EmployeeDomain employee = employeeDao.save(employeeDomain);
		return convertDomainToDto(employee);
	}

	@Override
	@Transactional
	public EmployeeDTO getById(Integer id) {
		final EmployeeDomain clientDomain = employeeDao.getById(id);
		final EmployeeDTO clientDTO = convertDomainToDto(clientDomain);
		return clientDTO;
	}

	@Override
	@Transactional
	public EmployeeResult getAll() {
		final List<EmployeeDTO> employees = new ArrayList<>();
		for (EmployeeDomain domain : employeeDao.findAll()) {
			final EmployeeDTO employee = convertDomainToDto(domain);
			employees.add(employee);
		}

		final EmployeeResult employeesResult = new EmployeeResult();
		employeesResult.setClients(employees);
		return employeesResult;
	}

	@Override
	protected EmployeeDTO convertDomainToDto(EmployeeDomain domain) {
		final EmployeeDTO employee = new EmployeeDTO();
		employee.setId(domain.getId());
		employee.setName(domain.getName());
		employee.setSurName(domain.getSurName());
		employee.setRuc(domain.getRuc());
		employee.setAddress(domain.getAddress());
		employee.setType(domain.getType());
		employee.setCellphone(domain.getCellphone());
		return employee;
	}

	@Override
	protected EmployeeDomain convertDtoToDomain(EmployeeDTO dto) {
		final EmployeeDomain employee = new EmployeeDomain();
		employee.setId(dto.getId());
		employee.setName(dto.getName());
		employee.setSurName(dto.getSurName());
		employee.setRuc(dto.getRuc());
		employee.setAddress(dto.getAddress());
		employee.setType(dto.getType());
		employee.setCellphone(dto.getCellphone());
		return employee;
	}

}
