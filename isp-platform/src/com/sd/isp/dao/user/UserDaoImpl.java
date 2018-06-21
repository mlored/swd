package com.sd.isp.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from users where username=:name");	
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
	
	public List<UserDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDomain.class);
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("username", "%"+text+"%"))
						.add(Restrictions.ilike("name", "%"+text+"%"))
						.add(Restrictions.ilike("surName", "%"+text+"%"));
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
				if(sort.equals("name") || sort.equals("username") 
									   || sort.equals("surName")) {
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
				criteria.addOrder(Order.asc("surName").ignoreCase());
			}
		}else{
			criteria.addOrder(Order.asc("name").ignoreCase());
			criteria.addOrder(Order.asc("surName").ignoreCase());
		}
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<UserDomain> clients = criteria.list();
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
