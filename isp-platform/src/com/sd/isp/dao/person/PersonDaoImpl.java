package com.sd.isp.dao.person;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.person.PersonDomain;

@Repository
public class PersonDaoImpl extends BaseDaoImpl<PersonDomain> implements IPersonDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PersonDomain> findByName(String textToFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDomain save(PersonDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	@Override
	public PersonDomain getById(Integer domainId) {
		return (PersonDomain) sessionFactory.getCurrentSession().get(PersonDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonDomain.class);
		return criteria.list();
	}

	@Override
	public PersonDomain updateById(Integer domainId, PersonDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDomain delete(Integer domainId) {
		PersonDomain domain = (PersonDomain) sessionFactory.getCurrentSession().get(PersonDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}

