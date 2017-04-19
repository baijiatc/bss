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
import cn.bjtc.service.IParametersService;
import cn.bjtc.view.ParametersView;

@RestController
@RequestMapping("parameters")
public class ParametersController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showActParameters(){
		 ApiParam param=ApiManager.getInstance().getParameters(request);
		 ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
		 int count=parameterservice.countAllParameterss(view);
		 List<?> parameters=parameterservice.findAllParameterss(view);
		 apiReturn.setCount(count);
		 apiReturn.setData(parameters);
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddParameters(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
		parameterservice.saveParameters(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateParameters(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
		parameterservice.updateParameters(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditParameters(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
		List<?> parameters=parameterservice.findAllParameterss(view);
		apiReturn.setData(parameters);
		return apiReturn;
	}
	
	@Autowired
	private IParametersService parameterservice;
}
