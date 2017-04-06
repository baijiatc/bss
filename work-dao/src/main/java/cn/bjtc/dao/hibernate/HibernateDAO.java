package cn.bjtc.dao.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import cn.bjtc.dao.IGenericDAO;

public class HibernateDAO<T, K> implements IGenericDAO<T, K> {
	
	@Autowired
	private HibernateTemplate template;
	
	public List<T> findAll(String queryString, Object[] values){
		return (List<T>) template.find(queryString, values);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
}
