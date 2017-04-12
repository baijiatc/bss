package cn.bjtc.dao.utils;

import java.util.HashMap;
import java.util.Map;

public class DBChooser {
	
	public static Map<String, String> dbDriverMap = new HashMap<String, String>();
	public static Map<String, String> dbUrlMap = new HashMap<String, String>();
	
	static{
		dbDriverMap.put("MYSQL", "com.mysql.jdbc.Driver");
		dbUrlMap.put("MYSQL", "jdbc:mysql://%s:%d/%s");
	}

	public static String chooseDBDriver(String dbType){
		if(dbDriverMap.containsKey(dbType)){
			return dbDriverMap.get(dbType);
		}
		return null;
	}
	
	public static String chooseDBUrl(String dbType){
		if(dbUrlMap.containsKey(dbType)){
			return dbUrlMap.get(dbType);
		}
		return null;
	}
}
