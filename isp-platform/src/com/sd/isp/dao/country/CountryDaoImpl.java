package com.sd.isp.dao.country;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.location.country.CountryDomain;

@Repository
public class CountryDaoImpl extends BaseDaoImpl<CountryDomain> implements ICountryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CountryDomain save(CountryDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public CountryDomain getById(Integer domainId) {
		return (CountryDomain) sessionFactory.getCurrentSession().get(CountryDomain.class, domainId);
	}

	@Override
	public List<CountryDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CountryDomain.class);
		return criteria.list();
	}

}
