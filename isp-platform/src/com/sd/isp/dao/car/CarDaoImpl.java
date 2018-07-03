package com.sd.isp.dao.car;

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
		CarDomain carDomain = (CarDomain) sessionFactory.getCurrentSession().get(CarDomain.class, domainId);
		carDomain.setMark(domain.getMark());
		carDomain.setModel(domain.getModel());
		carDomain.setYear(domain.getYear());
		carDomain.setColor(domain.getColor());
		carDomain.setEntryDomains(domain.getEntryDomains());
		sessionFactory.getCurrentSession().saveOrUpdate(carDomain);
		return carDomain;
	}

	@Override
	public CarDomain delete(Integer domainId) {
		CarDomain domain = (CarDomain) sessionFactory.getCurrentSession().get(CarDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}
	
	@Override
	public List<CarDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CarDomain.class);
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("mark", "%"+text+"%"))
						.add(Restrictions.ilike("model", "%"+text+"%"))
						.add(Restrictions.ilike("color", "%"+text+"%"));
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
					if(sort.equals("mark") || sort.equals("model") 
										     || sort.equals("color")){
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
					criteria.addOrder(Order.asc("mark").ignoreCase());
					criteria.addOrder(Order.asc("model").ignoreCase());
				}
			}else{
				criteria.addOrder(Order.asc("mark").ignoreCase());
				criteria.addOrder(Order.asc("model").ignoreCase());
			}
				criteria.setFirstResult(page * maxItems);
				criteria.setMaxResults(maxItems);
				criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				List<CarDomain> cars = criteria.list();
				return cars;
	   }

	/**
	 * Diccionario: clave=columna de la bd y valor=valor a buscar
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
