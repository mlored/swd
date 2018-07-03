package com.sd.isp.dao.report;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
//import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.report.ReportDomain;
//import java.text.ParseException;
import java.text.SimpleDateFormat;

@Repository
public class ReportDaoImpl extends BaseDaoImpl<ReportDomain> implements IReportDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ReportDomain save(ReportDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ReportDomain getById(Integer domainId) /*throws AutomotiveException*/  {
		if (null != domainId) {
			try {
				return (ReportDomain) sessionFactory.getCurrentSession().get(ReportDomain.class, domainId);
			} catch (Exception e) {
				System.out.println("No existe el reporte con id ");
			
			}
		} else {
			System.out.println("El ID no puede ser null");
			
		}
		return null; 
	}

	//@SuppressWarnings("unchecked")
	@Override
	public List<ReportDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReportDomain.class);
		return criteria.list();
	}

	@Override
	public List<ReportDomain> find(String textToFind, int page, int maxItems) throws Exception {
		Date minDate, maxDate;
		Session session   = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ReportDomain.class, "report").createAlias("report._employee", "employee");
		if (textToFind != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map    = obtenerQuery(textToFind);

			if (map.containsKey("isActived")) {
				criteria.add(Restrictions.eq("_isActived", map.get("isActived")));
			}
		}
		criteria.addOrder(Order.desc("_id"));
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ReportDomain> reports = criteria.list();
		return reports;

	} 
	
	@Override
	public List<ReportDomain> find(String textToFind)/* throws AutomotiveException*/ {
		Date minDate, maxDate;
		Session session   = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ReportDomain.class, "report").createAlias("report._employee", "employee");

		if (textToFind != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);

			if (map.containsKey("isActived")) { 
				criteria.add(Restrictions.eq("_isActived", Boolean.parseBoolean(map.get("isActived"))));
			}

		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ReportDomain> reports = criteria.list();
		return reports;
	}
	
	private Map<String, String> obtenerQuery(String textToFind) {
		String[] params = textToFind.split("&");
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (String param : params) {
				String name  = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public ReportDomain updateById(Integer domainId, ReportDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportDomain delete(Integer domainId) {
		// TODO Auto-generated method stub
		return null;
	}

}
