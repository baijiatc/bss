package cn.bjtc.dao.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import cn.bjtc.dao.IGenericDAO;

public class MongoDAO<T, K> implements IGenericDAO<T, K> {

	@Autowired
	private MongoTemplate template;

	public MongoTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}
	
}
