package cn.bjtc.dao.jdbc.spring;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import cn.bjtc.dao.DML;
import cn.bjtc.dao.IGenericDAO;
import cn.bjtc.dao.utils.EntitySqlResolver;

public class SpringJdbcDAO<T, K> implements IGenericDAO<T, K> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String processTableName(){
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> entityClass = (Class<T>) type.getActualTypeArguments()[0];
		return entityClass.getSimpleName().toLowerCase();
	}
	
	public void save(T entity) {
		EntitySqlResolver<T> sqlMaker = new EntitySqlResolver<T>();
		String sql = sqlMaker.makeSql(DML.INSERT);
		 Object[] args = sqlMaker.setArgs(entity, DML.INSERT);
        int[] argTypes = sqlMaker.setArgTypes(entity, DML.INSERT);
        jdbcTemplate.update(sql.toString(), args, argTypes);
	}
	
	public void update(T entity){
		EntitySqlResolver<T> sqlMaker = new EntitySqlResolver<T>();
		String sql = sqlMaker.makeSql(DML.UPDATE);
        Object[] args = sqlMaker.setArgs(entity, DML.UPDATE);
        int[] argTypes = sqlMaker.setArgTypes(entity, DML.UPDATE);
        jdbcTemplate.update(sql, args, argTypes);
	}
	
	public void delete(T entity) {
		EntitySqlResolver<T> sqlMaker = new EntitySqlResolver<T>();
        String sql = sqlMaker.makeSql(DML.DELETE);
        Object[] args = sqlMaker.setArgs(entity, DML.DELETE);
        int[] argTypes = sqlMaker.setArgTypes(entity, DML.DELETE);
        jdbcTemplate.update(sql, args, argTypes);
    }
	
	public void deleteAll() {
        String sql = " TRUNCATE TABLE " + processTableName();
        jdbcTemplate.execute(sql);
    }
	
	public void batchDelete(K[] ids) {
        String idStr="";
        for (int i = 0; i < ids.length; i++) {
            idStr+=",'"+ids[i]+"'";
        }
        String sql = " DELETE FROM " + processTableName() + " WHERE id in (?)";
        jdbcTemplate.update(sql, idStr.charAt(1));
    }
	
	public void deleteById(K id) {
        String sql = " DELETE FROM " + processTableName() + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
	
	public void batchSave(List<T> lt) {
        Assert.notEmpty(lt);
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(processTableName().toLowerCase()).append("( ");
        List<Object[]> params = new ArrayList<Object[]>();
        String val = "";

        for (T t : lt) {
            int index = 0;
            Field[] fields = t.getClass().getDeclaredFields();
            if (fields != null && fields.length > 0) {
                Object[] objVal = new Object[fields.length];

                for (Field field : fields) {
                    try {
                        field.setAccessible(true);
                        Object obj = field.get(t);
                        if (params.size() == 0) {
                            sb.append(field.getName()).append(" ,");
                            val += ", ? ";
                        }
                        objVal[index++] = obj;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                params.add(objVal);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        val = val.substring(1);
        sb.append(") value (").append(val).append(")");
        String sql = sb.toString();
        jdbcTemplate.batchUpdate(sql, params);
    }
	
	public void batchUpdate(List<T> lt) {
        Assert.notEmpty(lt);
        StringBuilder sb = new StringBuilder();
        sb.append("update ").append(processTableName().toLowerCase()).append(" set ");
        List<Object[]> params = new ArrayList<Object[]>();
        Object primaryKey = "id";
        for (T t : lt) {
            int index = 0;
            Field[] fields = t.getClass().getDeclaredFields();
            if (fields != null && fields.length > 0) {
                Object id = null;
                Object[] objVal = new Object[fields.length];
                for (Field field : fields) {
                    try {
                        field.setAccessible(true);
                        Object obj = field.get(t);
                        if (field.getName().equalsIgnoreCase("id")) {
                            primaryKey = obj;
                            id = obj;
                        } else {
                            if (params.size() == 0) {
                                sb.append(field.getName()).append(" = ? ,");
                            }
                            objVal[index++] = obj;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    objVal[index] = id;
                }
                params.add(objVal);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" where ").append(primaryKey).append(" = ? ");
        String sql = sb.toString();
        jdbcTemplate.batchUpdate(sql, params);
    }
	
	public void execSQL(String sql) {
		jdbcTemplate.execute(sql);
    }

	public List<T> findAll(String sql,Object... args){
		return (List<T>) jdbcTemplate.queryForList(sql,args);
	}

	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
