package com.sd.isp.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.user.UserDomain;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDomain> implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDomain save(UserDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public UserDomain getById(Integer domainId) {
		return (UserDomain) sessionFactory.getCurrentSession().get(UserDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDomain.class);
		return criteria.list();
	}

	@Override
	public UserDomain updateById(Integer domainId, UserDomain domain) {
		UserDomain userDomain = (UserDomain) sessionFactory.getCurrentSession().get(UserDomain.class, domainId);
		userDomain.setUsername(domain.getUsername());
		userDomain.setName(domain.getName());
		userDomain.setSurName(domain.getSurName());
		userDomain.setPassword(domain.getPassword());
		sessionFactory.getCurrentSession().saveOrUpdate(userDomain);
		return userDomain;
	}

	public UserDomain delete(UserDomain domain) {
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

	@Override
	public UserDomain getByUsername(String name) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from user where username=:name");	
		query.addEntity(UserDomain.class); 
		query.setString("name", name);
		return (UserDomain) query.uniqueResult();	
	}

	@Override
	public UserDomain delete(Integer domainId) {
		UserDomain domain = (UserDomain) sessionFactory.getCurrentSession().get(UserDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
