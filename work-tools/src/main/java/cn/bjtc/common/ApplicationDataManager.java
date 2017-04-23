package cn.bjtc.common;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApplicationDataManager {
	//系统api
	public static final Map<Integer,String> SYSAPIMAP = new ConcurrentHashMap<Integer, String>();
	//系统参数
	public static final Map<String,String> SYSPARAMS = new ConcurrentHashMap<String, String>();
	//系统菜单[[parent1,[[child1,[element1]]]],[parent2,[[child2,[element2]]]]]
	public static final List<Object> SYSMENUS = new CopyOnWriteArrayList<Object>();
	//系统字典{dictvalue:{dictvalue:dictname}}
	public static final Map<String,Map<String,String>> SYSDICTS = new ConcurrentHashMap<String,Map<String,String>>();
	//菜单权限{menuid:privid}
	public static final Map<String,Object> SYSMENUPRIVS = new ConcurrentHashMap<String,Object>();
	//元素权限{elemid:privid}
	public static final Map<String,Object> SYSELEMPRIVS = new ConcurrentHashMap<String,Object>();
	//用户权限{uname+uid:privs}
	public static final Map<String, Map<String, Object>> USERPRIVS = new ConcurrentHashMap<String,Map<String, Object>>();
	//库存预警因子{name:id}
	public static final Map<String,Object> SYSFACTORS = new ConcurrentHashMap<String,Object>();
	//预警因子反转{id:name}
	public static final Map<String,String> SYSFACTORSRESERVE = new ConcurrentHashMap<String,String>();
	//行政区域{parentid:[child]}
	public static final Map<String,Object> SYSREGIONS = new ConcurrentHashMap<String,Object>();
	
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
	
	public static String getFactorStringById(Object factorid){
		return SYSFACTORSRESERVE.get(DEFAULT_KEY+factorid);
	}
	
	public static List<Object> getRegionsByParent(Object parentid){
		return (List<Object>) SYSREGIONS.get(DEFAULT_KEY+parentid);
	}
}