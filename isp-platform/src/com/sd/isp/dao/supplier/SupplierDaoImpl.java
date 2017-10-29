package com.sd.isp.dao.supplier;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.supplier.SupplierDomain;

@Repository
public class SupplierDaoImpl extends BaseDaoImpl<SupplierDomain> implements ISupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SupplierDomain save(SupplierDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public SupplierDomain getById(Integer domainId) {
		return (SupplierDomain) sessionFactory.getCurrentSession().get(SupplierDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplierDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SupplierDomain.class);
		return criteria.list();
	}

	@Override
	public SupplierDomain updateById(Integer domainId, SupplierDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDomain delete(Integer domainId) {
		// TODO Auto-generated method stub
		return null;
	}

}
