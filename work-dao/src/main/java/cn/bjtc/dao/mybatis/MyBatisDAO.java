package cn.bjtc.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.dao.IGenericDAO;

public class MyBatisDAO<T, K> implements IGenericDAO<T, K> {
	
	@Autowired
	private SqlSessionTemplate mybatisTemplate;

	public int save(String statement,T entity) {
		return mybatisTemplate.insert(statement, entity);
	}
	
	public int update(String statement, Object parameter){
		return mybatisTemplate.update(statement, parameter);
	}
	
	public List<T> findByParam(String statement, Object parameter){
		return mybatisTemplate.selectList(statement, parameter);
	}
	
	public Integer countByParam(String statement, Object parameter){
		return mybatisTemplate.selectOne(statement,parameter);
	}

	private SqlSessionTemplate getMybatisTemplate() {
		return mybatisTemplate;
	}

	private void setMybatisTemplate(SqlSessionTemplate mybatisTemplate) {
		this.mybatisTemplate = mybatisTemplate;
	}
	
}
