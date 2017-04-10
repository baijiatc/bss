package cn.bjtc.dao.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import cn.bjtc.dao.IGenericDAO;

public class HibernateDAO<T, K> implements IGenericDAO<T, K> {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<T> findAll(String queryString, Object[] values){
		return (List<T>) hibernateTemplate.find(queryString, values);
	}

	private HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	private void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
