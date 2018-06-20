package com.sd.isp.dao.client;

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

	@Override
	public ClientDomain updateById(Integer domainId, ClientDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDomain delete(Integer domainId) {
		ClientDomain domain = (ClientDomain) sessionFactory.getCurrentSession().get(ClientDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}
	
	@Override
	public List<ClientDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ClientDomain.class);
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("name", "%"+text+"%"))
						.add(Restrictions.ilike("surname", "%"+text+"%"))
						.add(Restrictions.ilike("cellphone", "%"+text+"%"))
						.add(Restrictions.ilike("RUC", "%"+text+"%"))
						.add(Restrictions.ilike("address", "%"+text+"%"));
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
					if(sort.equals("name") || sort.equals("surname") 
										   || sort.equals("cellphone") 
										   || sort.equals("RUC") 
										   || sort.equals("address")){
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
					criteria.addOrder(Order.asc("surname").ignoreCase());
				}
			}else{
				criteria.addOrder(Order.asc("name").ignoreCase());
				criteria.addOrder(Order.asc("surname").ignoreCase());
			}
				criteria.setFirstResult(page * maxItems);
				criteria.setMaxResults(maxItems);
				criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				List<ClientDomain> clients = criteria.list();
				return clients;
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
