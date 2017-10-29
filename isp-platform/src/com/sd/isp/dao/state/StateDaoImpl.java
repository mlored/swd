package com.sd.isp.dao.state;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.location.state.StateDomain;

@Repository
public class StateDaoImpl extends BaseDaoImpl<StateDomain> implements IStateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public StateDomain save(StateDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;

	}

	@Override
	public StateDomain getById(Integer domainId) {
		return (StateDomain) sessionFactory.getCurrentSession().get(StateDomain.class, domainId);
	}

	@Override
	public List<StateDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StateDomain.class);
		return criteria.list();
	}

	@Override
	public StateDomain updateById(Integer domainId, StateDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateDomain delete(Integer domainId) {
		// TODO Auto-generated method stub
		return null;
	}

}
