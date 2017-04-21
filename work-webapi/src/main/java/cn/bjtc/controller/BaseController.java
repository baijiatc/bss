package cn.bjtc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.common.WebConstants;

public class BaseController {
	protected ApiReturn apiReturn;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.apiReturn = new ApiReturn();
	}
	
	protected String validParam(ApiParam param){
		Integer code = param.getCode();
		if(code == null){
			return "forward:./../ex/needcode.json";
		}else if(ApplicationDataManager.SYSAPIMAP.containsKey(code)){
			request.setAttribute(WebConstants.REQUEST_PARAM, param);
			String forward = "forward:./"+ApplicationDataManager.SYSAPIMAP.get(code);
			return forward;
		}else{
			return "forward:./../ex/unsupport.json";
		}
	}
	
	protected void showServerError(){
		try {
			request.getRequestDispatcher("./../ex/srverr.json").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void ifParamDataIsEmpty(ApiParam param){
		List<Map<String, Object>> datas = param.getData();
		if(datas == null || datas.size() == 0){
			try {
				request.getRequestDispatcher("./../ex/needcode.json").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected ApiParam findApiParam(){
		Object obj = request.getAttribute(WebConstants.REQUEST_PARAM);
		ApiParam param = (ApiParam) obj;
		return param;
	}
}
