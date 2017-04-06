package cn.bjtc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

import cn.bjtc.api.ApiReturn;

public class BaseController {
	protected final ApiReturn apiReturn = new ApiReturn();
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
}
