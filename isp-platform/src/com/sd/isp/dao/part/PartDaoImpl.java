package com.sd.isp.dao.part;

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
import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.domain.employee.EmployeeDomain;
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
	
	@Override
	public List<PartDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PartDomain.class);
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
				List<PartDomain> parts = criteria.list();
				return parts;
	   }
	
	/**
	 * Creo un diccionario con clave valor En donde clave=columna de la bd y
	 * valor=valor a buscar
	 */
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
