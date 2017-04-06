package cn.bjtc.dao.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Types;

import cn.bjtc.dao.DML;

public class EntitySqlResolver<T> {
	
	private Class <T> entityClass;
	private Field[] fields;
	
	public EntitySqlResolver(){
		entityClass=(Class <T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		fields = entityClass.getDeclaredFields();
	}

	public Object[] setArgs(T entity, DML dml){
		if(DML.INSERT.equals(dml)){
			Object[] args = new Object[fields.length];
			for (int i = 0; args != null && i < args.length; i++) {
                try {
                    fields[i].setAccessible(true); // 暴力反射
                    args[i] = fields[i].get(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return args;
		}else if (DML.UPDATE.equals(dml)) {
            Object[] tempArr = new Object[fields.length];
            for (int i = 0; tempArr != null && i < tempArr.length; i++) {
                try {
                    fields[i].setAccessible(true); // 暴力反射
                    tempArr[i] = fields[i].get(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Object[] args = new Object[fields.length];
            System.arraycopy(tempArr, 1, args, 0, tempArr.length - 1); // 数组拷贝
            args[args.length - 1] = tempArr[0];
            return args;
        } else if (DML.DELETE.equals(dml)) {
            Object[] args = new Object[1]; // 长度是1
            fields[0].setAccessible(true); // 暴力反射
            try {
                args[0] = fields[0].get(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return args;
        }
        return null;
	}
	
	/**
     * 设置参数类型（写的不全，只是一些常用的）
     * 
     * @param entity
     * @param sqlFlag
     * @param entityClass
     * @return
     */
    public int[] setArgTypes(T entity, DML dml) {
        if (DML.INSERT.equals(dml)) {
            int[] argTypes = new int[fields.length];
            try {
                for (int i = 0; argTypes != null && i < argTypes.length; i++) {
                    fields[i].setAccessible(true); // 暴力反射
                    if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
                        argTypes[i] = Types.VARCHAR;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
                        argTypes[i] = Types.DECIMAL;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
                        argTypes[i] = Types.INTEGER;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
                        argTypes[i] = Types.DATE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return argTypes;
        } else if (DML.UPDATE.equals(dml)) {
            int[] tempArgTypes = new int[fields.length];
            int[] argTypes = new int[fields.length];
            try {
                for (int i = 0; tempArgTypes != null && i < tempArgTypes.length; i++) {
                    fields[i].setAccessible(true); // 暴力反射
                    if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
                        tempArgTypes[i] = Types.VARCHAR;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
                        tempArgTypes[i] = Types.DECIMAL;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
                        tempArgTypes[i] = Types.INTEGER;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
                        tempArgTypes[i] = Types.DATE;
                    }
                }
                System.arraycopy(tempArgTypes, 1, argTypes, 0, tempArgTypes.length - 1); // 数组拷贝
                argTypes[argTypes.length - 1] = tempArgTypes[0];

            } catch (Exception e) {
                e.printStackTrace();
            }
            return argTypes;

        } else if (DML.DELETE.equals(dml)) {
            int[] argTypes = new int[1]; // 长度是1
            try {
                fields[0].setAccessible(true); // 暴力反射
                if (fields[0].get(entity).getClass().getName().equals("java.lang.String")) {
                    argTypes[0] = Types.VARCHAR;
                } else if (fields[0].get(entity).getClass().getName().equals("java.lang.Integer")) {
                    argTypes[0] = Types.INTEGER;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return argTypes;
        }
        return null;
    }
    
    public String makeSql(DML dml) {
        StringBuffer sql = new StringBuffer();
        if (DML.INSERT.equals(dml)) {
            sql.append(" INSERT INTO " + entityClass.getSimpleName());
            sql.append("(");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true); // 暴力反射
                String column = fields[i].getName();
                sql.append(column).append(",");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(") VALUES (");
            for (int i = 0; fields != null && i < fields.length; i++) {
                sql.append("?,");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(")");
        } else if (DML.UPDATE.equals(dml)) {
            sql.append(" UPDATE " + entityClass.getSimpleName() + " SET ");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true); // 暴力反射
                String column = fields[i].getName();
                if (column.equals("id")) { // id 代表主键
                    continue;
                }
                sql.append(column).append("=").append("?,");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE id=?");
        } else if (DML.DELETE.equals(dml)) {
            sql.append(" DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?");
        }
        System.out.println("SQL=" + sql);
        return sql.toString();
    }
}
