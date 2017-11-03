package com.sd.isp.dao.sell;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.sell.SellDomain;

@Repository
public class SellDaoImpl extends BaseDaoImpl<SellDomain> implements ISellDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SellDomain save(SellDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public SellDomain getById(Integer domainId) {
		return (SellDomain) sessionFactory.getCurrentSession().get(SellDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SellDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SellDomain.class);
		return criteria.list();
	}
	
	@Override
	public SellDomain updateById(Integer domainId, SellDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellDomain delete(Integer domainId) {
		SellDomain domain = (SellDomain) sessionFactory.getCurrentSession().get(SellDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
