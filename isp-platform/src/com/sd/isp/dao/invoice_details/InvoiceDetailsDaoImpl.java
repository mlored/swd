package com.sd.isp.dao.invoice_details;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.domain.invoice_details.InvoiceDetailsDomain;

@Repository
public class InvoiceDetailsDaoImpl extends BaseDaoImpl<InvoiceDetailsDomain> implements IInvoiceDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public InvoiceDetailsDomain save(InvoiceDetailsDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public InvoiceDetailsDomain getById(Integer domainId) {
		return (InvoiceDetailsDomain) sessionFactory.getCurrentSession().get(InvoiceDetailsDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceDetailsDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InvoiceDetailsDomain.class);
		return criteria.list();
	}

	@Override
	public InvoiceDetailsDomain updateById(Integer domainId, InvoiceDetailsDomain domain) {
		InvoiceDetailsDomain invoiceDomailsDomain = (InvoiceDetailsDomain) sessionFactory.getCurrentSession().get(BuyDomain.class, domainId);
		invoiceDomailsDomain.setQuantity(domain.getQuantity());
		invoiceDomailsDomain.setPrice(domain.getPrice());
		sessionFactory.getCurrentSession().saveOrUpdate(invoiceDomailsDomain);
		return invoiceDomailsDomain;
	}

	@Override
	public InvoiceDetailsDomain delete(Integer domainId) {
		InvoiceDetailsDomain domain = (InvoiceDetailsDomain) sessionFactory.getCurrentSession().get(InvoiceDetailsDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
