package com.sd.isp.dao.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.client.ClientDomain;

@Repository
public class ClientDaoImpl extends BaseDaoImpl<ClientDomain> implements IClientDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ClientDomain> findByName(String textToFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDomain save(ClientDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	@Override
	public ClientDomain getById(Integer domainId) {
		return (ClientDomain) sessionFactory.getCurrentSession().get(ClientDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientDomain.class);
		return criteria.list();
	}

}
