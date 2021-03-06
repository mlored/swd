package com.sd.isp.dao.entry;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.entry.EntryDomain;

@Repository
public class EntryDaoImpl extends BaseDaoImpl<EntryDomain> implements IEntryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EntryDomain save(EntryDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EntryDomain getById(Integer domainId) {
		return (EntryDomain) sessionFactory.getCurrentSession().get(EntryDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntryDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EntryDomain.class);
		return criteria.list();
	}

	@Override
	public EntryDomain updateById(Integer domainId, EntryDomain domain) {
		EntryDomain entryDomain = (EntryDomain) sessionFactory.getCurrentSession().get(EntryDomain.class, domainId);
		entryDomain.setDate(domain.getDate());
		entryDomain.setDiagnostic(domain.getDiagnostic());
		entryDomain.setNumber(domain.getNumber());
		entryDomain.setCarDomain(domain.getCarDomain());
		entryDomain.setClientDomain(domain.getClientDomain());
		
		sessionFactory.getCurrentSession().saveOrUpdate(entryDomain);
		return entryDomain;
	}

	@Override
	public EntryDomain delete(Integer domainId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<EntryDomain> find(String textToFind, int page, int maxItems) {
		return null;
	}

}
