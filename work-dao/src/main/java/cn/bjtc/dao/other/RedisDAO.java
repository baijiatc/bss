package cn.bjtc.dao.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import cn.bjtc.dao.IGenericDAO;

public class RedisDAO<T, K> implements IGenericDAO<T, K> {

	@Autowired
	private RedisTemplate template;

	public RedisTemplate getTemplate() {
		return template;
	}

	public void setTemplate(RedisTemplate template) {
		this.template = template;
	}
	
}
