package com.sd.isp.dao.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.service.ServiceDomain;

@Repository
public class ServiceDaoImpl extends BaseDaoImpl<ServiceDomain> implements IServiceDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ServiceDomain save(ServiceDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	@Override
	public ServiceDomain getById(Integer domainId) {
		return (ServiceDomain) sessionFactory.getCurrentSession().get(ServiceDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ServiceDomain.class);
		return criteria.list();
	}

	@Override
	public ServiceDomain updateById(Integer domainId, ServiceDomain domain) {
		ServiceDomain serviceDomain = (ServiceDomain) sessionFactory.getCurrentSession().get(ServiceDomain.class, domainId);
		serviceDomain.setName(domain.getName());
		serviceDomain.setDescription(domain.getDescription());
		serviceDomain.setPrice(domain.getPrice());
		serviceDomain.setQuantity(domain.getQuantity());
		sessionFactory.getCurrentSession().saveOrUpdate(serviceDomain);
		return serviceDomain;
	}

	@Override
	public ServiceDomain delete(Integer domainId) {
		ServiceDomain domain = (ServiceDomain) sessionFactory.getCurrentSession().get(ServiceDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}
	
	@Override
	public List<ServiceDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ServiceDomain.class);
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("name", "%"+text+"%"))
						.add(Restrictions.ilike("description", "%"+text+"%"));
						//.add(Restrictions.ilike("price", "%"+text+"%"));
				Criterion idCriterion = null;
				if (StringUtils.isNumeric(text)) {
					idCriterion = Restrictions.eq("id", Integer.valueOf(text));
				}
				if (idCriterion != null) {
					criteria.add(Restrictions.or(propertyCriterion, idCriterion));
				} else {
					criteria.add(propertyCriterion);
				}
			}
				if (map.containsKey("sort")) {
					String sort = (map.get("sort"));
					if(sort.equals("name") || sort.equals("description") 
										   || sort.equals("price")){
						if (map.containsKey("order")){
							String order = (map.get("order"));
							if(order.equals("desc")){
								criteria.addOrder(Order.desc(sort).ignoreCase());
							}else{
								criteria.addOrder(Order.asc(sort).ignoreCase());
							}
						}else{
							criteria.addOrder(Order.asc(sort).ignoreCase());
							criteria.addOrder(Order.asc(sort).ignoreCase());
						}
					}
				}else{
					criteria.addOrder(Order.asc("name").ignoreCase());
					criteria.addOrder(Order.asc("description").ignoreCase());
				}
			}else{
				criteria.addOrder(Order.asc("name").ignoreCase());
				criteria.addOrder(Order.asc("description").ignoreCase());
			}
				criteria.setFirstResult(page * maxItems);
				criteria.setMaxResults(maxItems);
				criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				List<ServiceDomain> service = criteria.list();
				return service;
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


}

