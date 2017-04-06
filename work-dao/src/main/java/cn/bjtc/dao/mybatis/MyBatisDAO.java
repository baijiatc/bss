package cn.bjtc.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.dao.IGenericDAO;

public class MyBatisDAO<T, K> implements IGenericDAO<T, K> {
	
	@Autowired
	private SqlSessionTemplate template;

	public int save(String statement,T entity) {
		return template.insert(statement, entity);
	}
	
	public int update(String statement, Object parameter){
		return template.update(statement, parameter);
	}
	
	public List<T> findByParam(String statement, Object parameter){
		return template.selectList(statement, parameter);
	}
	
	public Integer countByParam(String statement, Object parameter){
		return template.selectOne(statement,parameter);
	}

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
}
