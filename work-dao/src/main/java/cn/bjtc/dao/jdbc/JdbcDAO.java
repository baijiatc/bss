package cn.bjtc.dao.jdbc;

import cn.bjtc.dao.DML;
import cn.bjtc.dao.IGenericDAO;
import cn.bjtc.dao.utils.EntitySqlResolver;
import cn.bjtc.dao.utils.JdbcManager;

public class JdbcDAO<T, K> implements IGenericDAO<T, K> {
	
	private static JdbcManager jdbcManager = JdbcManager.getInstance();
	
	public boolean save(T entity) {
		EntitySqlResolver<T> sqlMaker = new EntitySqlResolver<T>();
		String sql = sqlMaker.makeSql(DML.INSERT);
		Object[] args = sqlMaker.setArgs(entity, DML.INSERT);
        int[] argTypes = sqlMaker.setArgTypes(entity, DML.INSERT);
        jdbcManager.save(sql);
		return false;
	}

	public boolean update(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteById(K id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteByIds(K[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	public T getById(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
