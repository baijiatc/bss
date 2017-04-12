package cn.bjtc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.bjtc.api.ApiReturn;

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
	
	@ModelAttribute
	public ApiReturn validLogin(){
		if(SecurityUtils.getSubject()==null){
			apiReturn.setCode(1);
			apiReturn.setMessage("未授权，不可访问");
		}
		return apiReturn;
	}
}
