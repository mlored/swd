package com.sd.isp.dao.car;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.car.CarDomain;

@Repository
public class CarDaoImpl extends BaseDaoImpl<CarDomain> implements ICarDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CarDomain save(CarDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public CarDomain getById(Integer domainId) {
		return (CarDomain) sessionFactory.getCurrentSession().get(CarDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CarDomain.class);
		return criteria.list();
	}

	@Override
	public CarDomain updateById(Integer domainId, CarDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDomain delete(Integer domainId) {
		CarDomain domain = (CarDomain) sessionFactory.getCurrentSession().get(CarDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
