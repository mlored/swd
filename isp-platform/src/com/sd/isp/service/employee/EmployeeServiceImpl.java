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
	CacheManager cacheManager;

	@Override
	@Transactional
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'employee_getAll'"),
	                   @CacheEvict(value="isp-platform-cache", key="'employee_getById_'+#dto.getId()")})*/
    //@CachePut(value = "isp-platform-cache",key="'employee_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@CachePut(value = "isp-platform-cache",key="'employee_save'")
	public EmployeeDTO save(EmployeeDTO dto) {
		final EmployeeDomain employeeDomain = convertDtoToDomain(dto);
		final EmployeeDomain employee = employeeDao.save(employeeDomain);
		return convertDomainToDto(employee);
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'employee_'+ #id")
	//@Cacheable(value="isp-platform-cache", key="'employee_'+#root.methodName+'_'+#id")
	public EmployeeDTO getById(Integer id) {
		final EmployeeDomain employeeDomain = employeeDao.getById(id);
		final EmployeeDTO employeeDTO = convertDomainToDto(employeeDomain);
		return employeeDTO;
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'employee_getAll'")
	public EmployeeResult getAll() {
		final List<EmployeeDTO> employees = new ArrayList<>();
		for (EmployeeDomain domain : employeeDao.findAll()) {
			final EmployeeDTO employee = convertDomainToDto(domain);
			//cacheManager.getCache("isp-platform-cache").put("employee/_"+domain.getId(),domain);
			employees.add(employee);
		}

		final EmployeeResult employeesResult = new EmployeeResult();
		employeesResult.setEmployees(employees);
		return employeesResult;
	}
	
	@Override
	public EmployeeDTO updateById(Integer id, EmployeeDTO dto) {
		final EmployeeDomain newDomain = convertDtoToDomain(dto);
		final EmployeeDomain domain = employeeDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getName());
		domain.setRUC(newDomain.getRUC());
		domain.setAddress(newDomain.getAddress());
		domain.setCellphone(newDomain.getCellphone());
		final EmployeeDomain employeeDomain = employeeDao.save(domain);
		return convertDomainToDto(employeeDomain);
	}

	@Override
/*	@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'employee_getAll'"),
			   		   @CacheEvict(value="isp-platform-cache", key="'employee_getById_'+#dto.getId()")})*/
	public EmployeeDTO delete(Integer id) {
		final EmployeeDomain domain = employeeDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected EmployeeDTO convertDomainToDto(EmployeeDomain domain) {
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
	protected EmployeeDomain convertDtoToDomain(EmployeeDTO dto) {
		final EmployeeDomain employee = new EmployeeDomain();
		employee.setId(dto.getId());
		employee.setName(dto.getName());
		employee.setSurName(dto.getSurName());
		employee.setRUC(dto.getRuc());
		employee.setAddress(dto.getAddress());
		employee.setCellphone(dto.getCellphone());
		return employee;
	}

}
