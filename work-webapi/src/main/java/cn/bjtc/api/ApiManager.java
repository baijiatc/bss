package cn.bjtc.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

public class ApiManager {

	public static final Map<Integer,String> API_MAP = new ConcurrentHashMap<Integer, String>();
	private static final String REQUEST_PARAM = "request.param";
	
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
