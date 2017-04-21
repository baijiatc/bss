package cn.bjtc.tools;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApplicationDataManager {
	public static final Map<Integer,String> SYSAPIMAP = new ConcurrentHashMap<Integer, String>();
	
	public static final Map<String,String> SYSPARAMS = new ConcurrentHashMap<String, String>();
	
	public static final List<Object> SYSMENUS = new CopyOnWriteArrayList<Object>();
	
	public static final Map<String,Map<String,String>> SYSDICTS = new ConcurrentHashMap<String,Map<String,String>>();
	
	public static final Map<String,Object> SYSMENUPRIVS = new ConcurrentHashMap<String,Object>();
	public static final Map<String,Object> SYSELEMPRIVS = new ConcurrentHashMap<String,Object>();
	
	public static final String DEFAULT_KEY = "app.key";
	
	public static String getSysParamByCode(String code){
		return SYSPARAMS.get(code);
	}
	
	public static String getDictValueByTypeValue(String type,String value){
		Map<String,String> valueMap = SYSDICTS.get(type);
		if(valueMap == null){
			return "";
		}
		return valueMap.get(value);
	}
}