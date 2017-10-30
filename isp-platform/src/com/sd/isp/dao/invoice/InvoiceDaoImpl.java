package com.sd.isp.dao.invoice;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.invoice.InvoiceDomain;

@Repository
public class InvoiceDaoImpl extends BaseDaoImpl<InvoiceDomain> implements IInvoiceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public InvoiceDomain save(InvoiceDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public InvoiceDomain getById(Integer domainId) {
		return (InvoiceDomain) sessionFactory.getCurrentSession().get(InvoiceDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InvoiceDomain.class);
		return criteria.list();
	}
	
	@Override
	public InvoiceDomain updateById(Integer domainId, InvoiceDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDomain delete(Integer domainId) {
		InvoiceDomain domain = (InvoiceDomain) sessionFactory.getCurrentSession().get(InvoiceDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
