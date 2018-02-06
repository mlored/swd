package com.sd.isp.dao.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.employee.EmployeeDomain;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<EmployeeDomain> implements IEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EmployeeDomain save(EmployeeDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EmployeeDomain getById(Integer domainId) {
		return (EmployeeDomain) sessionFactory.getCurrentSession().get(EmployeeDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeDomain.class);
		return criteria.list();
	}

	@Override
	public EmployeeDomain updateById(Integer domainId, EmployeeDomain domain) {
		EmployeeDomain employeeDomain = (EmployeeDomain) sessionFactory.getCurrentSession().get(EmployeeDomain.class, domainId);
		employeeDomain.setName(domain.getName());
		employeeDomain.setSurName(domain.getSurName());
		employeeDomain.setRUC(domain.getRUC());
		employeeDomain.setCellphone(domain.getCellphone());
		employeeDomain.setAddress(domain.getAddress());
		sessionFactory.getCurrentSession().saveOrUpdate(employeeDomain);
		return employeeDomain;
	}

	@Override
	public EmployeeDomain delete(Integer domainId) {
		EmployeeDomain domain = (EmployeeDomain) sessionFactory.getCurrentSession().get(EmployeeDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}	  	 	
	@Override
	public List<EmployeeDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeDomain.class);
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("name", "%"+text+"%"))
						.add(Restrictions.ilike("name", "%"+text+"%"))
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
					if(sort.equals("name") || sort.equals("surname") || sort.equals("cellphone") || sort.equals("RUC") || 
							sort.equals("address")){
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
				List<EmployeeDomain> employees = criteria.list();
				return employees;
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
				String name = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return map;
	}

}
