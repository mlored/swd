package com.sd.isp.dao.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.domain.service.ServiceDomain;

@Repository
public class ServiceDaoImpl extends BaseDaoImpl<ServiceDomain> implements IServiceDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ServiceDomain save(ServiceDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	@Override
	public ServiceDomain getById(Integer domainId) {
		return (ServiceDomain) sessionFactory.getCurrentSession().get(ServiceDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ServiceDomain.class);
		return criteria.list();
	}

	@Override
	public ServiceDomain updateById(Integer domainId, ServiceDomain domain) {
		ServiceDomain serviceDomain = (ServiceDomain) sessionFactory.getCurrentSession().get(ServiceDomain.class, domainId);
		serviceDomain.setName(domain.getName());
		serviceDomain.setDescription(domain.getDescription());
		serviceDomain.setPrice(domain.getPrice());
		serviceDomain.setQuantity(domain.getQuantity());
		sessionFactory.getCurrentSession().saveOrUpdate(serviceDomain);
		return serviceDomain;
	}

	@Override
	public ServiceDomain delete(Integer domainId) {
		ServiceDomain domain = (ServiceDomain) sessionFactory.getCurrentSession().get(ServiceDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}
	
	public List<ServiceDomain> find(String textToFind, int page, int maxItems) {
		return null;
	}

}

