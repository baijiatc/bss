package cn.bjtc.dao.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import cn.bjtc.dao.IGenericDAO;

public class RedisDAO<T, K> implements IGenericDAO<T, K> {

	@Autowired
	private RedisTemplate redisTemplate;

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
}
