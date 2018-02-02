package com.sd.isp.dao.support;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.support.SupportDomain;


@Repository
public class SupportDaoImpl  extends BaseDaoImpl<SupportDomain> implements ISupportDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SupportDomain save(SupportDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}
	@Override
	public SupportDomain getById(Integer domainId) {
		
			return (SupportDomain) sessionFactory.getCurrentSession().get(SupportDomain.class, domainId);
		
	}
	
	@Override
	public List<SupportDomain> findAll() {
		return null;
	}
	@Override
	public SupportDomain updateById(Integer domainId, SupportDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SupportDomain delete(Integer domainId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

