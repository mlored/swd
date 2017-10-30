package com.sd.isp.dao.buy;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.buy.BuyDomain;

@Repository
public class BuyDaoImpl extends BaseDaoImpl<BuyDomain> implements IBuyDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public BuyDomain save(BuyDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public BuyDomain getById(Integer domainId) {
		return (BuyDomain) sessionFactory.getCurrentSession().get(BuyDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BuyDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BuyDomain.class);
		return criteria.list();
	}
	
	@Override
	public BuyDomain updateById(Integer domainId, BuyDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyDomain delete(Integer domainId) {
		BuyDomain domain = (BuyDomain) sessionFactory.getCurrentSession().get(BuyDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
