package com.sd.isp.service.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.isp.rest.employee.EmployeeResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    private IEmployeeResource _employeeResource =new EmployeeResourceImpl();


    public EmployeeServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'employees'")
    @CachePut(value=CACHE_REGION, key="'employees' + #bean.id")
    public EmployeeB save(EmployeeB bean) {
        final EmployeeDTO employee = convertBeanToDto(bean);
        final EmployeeDTO dto = _employeeResource.save(employee);
        final EmployeeB employeeB = convertDtoToBean(dto);
        return employeeB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'employees'")
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
    @Cacheable(value=CACHE_REGION, key="'employees' + #id")
    public EmployeeB getById(Integer id) {
        final EmployeeDTO dto = _employeeResource.getById(id);
        final EmployeeB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'employees'"),
            @CacheEvict(value=CACHE_REGION, key = "'employees' + #id")})
    public EmployeeB delete(Integer id) {
        final EmployeeDTO dto = _employeeResource.destroy(id);
        final EmployeeB bean = convertDtoToBean(dto);
        return bean;
    }

    @Override
    public EmployeeB convertDtoToBean(EmployeeDTO dto) {
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
    public EmployeeDTO convertBeanToDto(EmployeeB bean) {
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
    @CacheEvict(value=CACHE_REGION, key = "'employees'")
    @CachePut(value=CACHE_REGION, key="'employees' + #id")
    public EmployeeB update(Integer id, EmployeeB employeeB) {
        final EmployeeDTO employee = convertBeanToDto(employeeB);
        final EmployeeDTO dto 	   = _employeeResource.update(id, employee);
        final EmployeeB bean 	   = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<EmployeeB> find(String textToFind, int maxItems, int page) {
        final EmployeeResult result = _employeeResource.find(textToFind, maxItems, page);
        final List<EmployeeDTO> rList = null == result.getEmployees() ? new ArrayList<EmployeeDTO>()
                : result.getEmployees();

        final List<EmployeeB> employees = new ArrayList<EmployeeB>();
        for (EmployeeDTO dto : rList) {
            final EmployeeB bean = convertDtoToBean(dto);
            employees.add(bean);
        }
        return employees;
    }
}
