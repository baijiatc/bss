package cn.bjtc.tools;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApplicationDataManager {
	public static final Map<String,String> SYSPARAMS = new ConcurrentHashMap<String, String>();
	
	public static final List<Object> SYSMENUS = new CopyOnWriteArrayList<Object>();
	
	public static String getSysParamByCode(String code){
		return SYSPARAMS.get(code);
	}
}
