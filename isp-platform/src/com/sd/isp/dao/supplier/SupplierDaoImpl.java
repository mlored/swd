package com.sd.isp.dao.supplier;

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
import com.sd.isp.domain.supplier.SupplierDomain;

@Repository
public class SupplierDaoImpl extends BaseDaoImpl<SupplierDomain> implements ISupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SupplierDomain save(SupplierDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public SupplierDomain getById(Integer domainId) {
		return (SupplierDomain) sessionFactory.getCurrentSession().get(SupplierDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplierDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SupplierDomain.class);
		return criteria.list();
	}

	@Override
	public SupplierDomain updateById(Integer domainId, SupplierDomain domain) {
		SupplierDomain supplierDomain = (SupplierDomain) sessionFactory.getCurrentSession().get(SupplierDomain.class, domainId);
		supplierDomain.setName(domain.getName());
		supplierDomain.setSurName(domain.getSurName());
		supplierDomain.setRUC(domain.getRUC());
		supplierDomain.setCellphone(domain.getCellphone());
		supplierDomain.setAddress(domain.getAddress());
		sessionFactory.getCurrentSession().saveOrUpdate(supplierDomain);
		return supplierDomain;
	}

	@Override
	public SupplierDomain delete(Integer domainId) {
		SupplierDomain domain = (SupplierDomain) sessionFactory.getCurrentSession().get(SupplierDomain.class, domainId);
		sessionFactory.getCurrentSession().delete(domain);
		return domain;
	}
	
	@Override
	public List<SupplierDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SupplierDomain.class);
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
				List<SupplierDomain> suppliers = criteria.list();
				return suppliers;
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
