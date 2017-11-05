package com.sd.isp.dao.employee;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.employee.EmployeeDomain;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<EmployeeDomain> implements IEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EmployeeDomain save(EmployeeDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EmployeeDomain getById(Integer domainId) {
		return (EmployeeDomain) sessionFactory.getCurrentSession().get(EmployeeDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeDomain.class);
		return criteria.list();
	}

	@Override
	public EmployeeDomain updateById(Integer domainId, EmployeeDomain domain) {
		EmployeeDomain employeeDomain = (EmployeeDomain) sessionFactory.getCurrentSession().get(EmployeeDomain.class, domainId);
		employeeDomain.setName(domain.getName());
		employeeDomain.setSurName(domain.getSurName());
		employeeDomain.setRUC(domain.getRUC());
		employeeDomain.setCellphone(domain.getCellphone());
		employeeDomain.setAddress(domain.getAddress());
		sessionFactory.getCurrentSession().saveOrUpdate(employeeDomain);
		return employeeDomain;
	}

	@Override
	public EmployeeDomain delete(Integer domainId) {
		EmployeeDomain domain = (EmployeeDomain) sessionFactory.getCurrentSession().get(EmployeeDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
