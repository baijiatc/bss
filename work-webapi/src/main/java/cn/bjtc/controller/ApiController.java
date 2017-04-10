package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IApiService;
import cn.bjtc.view.ApiView;

@RestController
@RequestMapping("api")
public class ApiController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showApis(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
		int count = apiService.countAllApis(view);
		List<?> privis = apiService.findAllApis(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddApi(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
		apiService.saveApi(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateApi(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
		apiService.updateApi(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditApi(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
		List<?> privis = apiService.findAllApis(view);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@Autowired
	private IApiService apiService;
}
