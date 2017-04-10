package cn.bjtc.dao.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import cn.bjtc.dao.IGenericDAO;

public class MongoDAO<T, K> implements IGenericDAO<T, K> {

	@Autowired
	private MongoTemplate mongoTemplate;

	private MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	private void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
