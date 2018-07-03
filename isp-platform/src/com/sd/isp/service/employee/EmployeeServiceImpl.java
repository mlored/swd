package com.sd.isp.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	@Transactional(readOnly = true)
	public EmployeeDTO getById(Integer id) {
		final EmployeeDomain employeeDomain = employeeDao.getById(id);
		return convertDomainToDto(employeeDomain);
	}

	@Override
	@Transactional(readOnly = true)
	public EmployeeResult getAll() {
		final List<EmployeeDTO> employees = new ArrayList<>();
		for (EmployeeDomain domain : employeeDao.findAll()) {			//findAll
			final EmployeeDTO employee = convertDomainToDto(domain);
			employees.add(employee);
		}

		final EmployeeResult employeesResult = new EmployeeResult();
		employeesResult.setEmployees(employees);
		return employeesResult;
	}
	
	@Override
	@Transactional
	public EmployeeDTO updateById(Integer id, EmployeeDTO dto) {
		final EmployeeDomain newDomain = convertDtoToDomain(dto);
		final EmployeeDomain domain = employeeDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getSurName());
		domain.setRUC(newDomain.getRUC());
		domain.setAddress(newDomain.getAddress());
		domain.setCellphone(newDomain.getCellphone());
		final EmployeeDomain employeeDomain = employeeDao.save(domain);
		return convertDomainToDto(employeeDomain);
	}

	@Override
	@Transactional
	public EmployeeDTO delete(Integer id) {
		final EmployeeDomain domain = employeeDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	public EmployeeDTO convertDomainToDto(EmployeeDomain domain) {
		final EmployeeDTO employee = new EmployeeDTO();
		employee.setId(domain.getId());
		employee.setName(domain.getName());
		employee.setSurName(domain.getSurName());
		employee.setRuc(domain.getRUC());
		employee.setAddress(domain.getAddress());
		employee.setCellphone(domain.getCellphone());
		return employee;
	}

	@Override
	public EmployeeDomain convertDtoToDomain(EmployeeDTO dto) {
		final EmployeeDomain employee = new EmployeeDomain();
		employee.setId(dto.getId());
		employee.setName(dto.getName());
		employee.setSurName(dto.getSurName());
		employee.setRUC(dto.getRuc());
		employee.setAddress(dto.getAddress());
		employee.setCellphone(dto.getCellphone());
		return employee;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeResult find(String textToFind, int page, int maxItems) throws Exception {
		final List<EmployeeDTO> employees = new ArrayList<>();
		for (EmployeeDomain domain : employeeDao.find(textToFind, page, maxItems)) {
			final EmployeeDTO dto = convertDomainToDto(domain);
			employees.add(dto);
		}
		final EmployeeResult employeeResult = new EmployeeResult();
		employeeResult.setEmployees(employees);
		return employeeResult;
	}

}
