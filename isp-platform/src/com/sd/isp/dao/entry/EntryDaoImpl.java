package com.sd.isp.dao.entry;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.location.city.CityDomain;

/*@Repository
public class EntryDaoImpl extends BaseDaoImpl<CityDomain> implements IEntryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CityDomain save(CityDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public CityDomain getById(Integer domainId) {
		return (CityDomain) sessionFactory.getCurrentSession().get(CityDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CityDomain.class);
		return criteria.list();
	}

}
*/