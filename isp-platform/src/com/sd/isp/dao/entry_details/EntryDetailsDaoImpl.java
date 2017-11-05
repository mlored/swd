package com.sd.isp.dao.entry_details;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.entry_details.EntryDetailsDomain;

@Repository
public class EntryDetailsDaoImpl extends BaseDaoImpl<EntryDetailsDomain> implements IEntryDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EntryDetailsDomain save(EntryDetailsDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EntryDetailsDomain getById(Integer domainId) {
		return (EntryDetailsDomain) sessionFactory.getCurrentSession().get(EntryDetailsDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntryDetailsDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EntryDetailsDomain.class);
		return criteria.list();
	}

	@Override
	public EntryDetailsDomain updateById(Integer domainId, EntryDetailsDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntryDetailsDomain delete(Integer domainId) {
		EntryDetailsDomain domain = (EntryDetailsDomain) sessionFactory.getCurrentSession().get(EntryDetailsDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}