package cn.bjtc.tools;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationDataManager {
	public static final Map<String,String> SYSPARAMS = new ConcurrentHashMap<String, String>();
	
	public static String getSysParamByCode(String code){
		return SYSPARAMS.get(code);
	}
}
