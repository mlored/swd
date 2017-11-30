package com.sd.isp.dao.part;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.part.PartDomain;

@Repository
public class PartDaoImpl extends BaseDaoImpl<PartDomain> implements IPartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PartDomain save(PartDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public PartDomain getById(Integer domainId) {
		return (PartDomain) sessionFactory.getCurrentSession().get(PartDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PartDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PartDomain.class);
		return criteria.list();
	}

	@Override
	public PartDomain updateById(Integer domainId, PartDomain domain) {
		PartDomain partDomain = (PartDomain) sessionFactory.getCurrentSession().get(PartDomain.class, domainId);
		partDomain.setName(domain.getName());
		partDomain.setDescription(domain.getDescription());
		partDomain.setPrice(domain.getPrice());
		partDomain.setQuantity(domain.getQuantity());
		sessionFactory.getCurrentSession().saveOrUpdate(partDomain);
		return partDomain;
	}

	@Override
	public PartDomain delete(Integer domainId) {
		PartDomain domain = (PartDomain) sessionFactory.getCurrentSession().get(PartDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}

}
