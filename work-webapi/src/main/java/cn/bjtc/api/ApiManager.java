package cn.bjtc.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

public class ApiManager {

	public static final Map<Integer,String> API_MAP = new ConcurrentHashMap<Integer, String>();
	private static final String REQUEST_PARAM = "request.param";
	
	static{
		API_MAP.put(10001, "../login.json");
		API_MAP.put(20001, "../priv/create.json");
		API_MAP.put(20002, "../priv/get.json");
		API_MAP.put(20003, "../priv/all.json");
		API_MAP.put(20004, "../priv/update.json");
		API_MAP.put(20005, "../role/create.json");
		API_MAP.put(20006, "../role/get.json");
		API_MAP.put(20007, "../role/all.json");
		API_MAP.put(20008, "../role/update.json");
	}
	
	public ApiParam getParameters(HttpServletRequest request){
		return (ApiParam) request.getAttribute(REQUEST_PARAM);
	}
	
	public void setParameters(HttpServletRequest request,ApiParam param){
		request.setAttribute(REQUEST_PARAM, param);
	}
	
	public static ApiManager getInstance(){
		return ApiManagerHolder.INSTANCE;
	}
	
	private ApiManager(){}
	private static class ApiManagerHolder{
		private static final ApiManager INSTANCE = new ApiManager();
	}
}
