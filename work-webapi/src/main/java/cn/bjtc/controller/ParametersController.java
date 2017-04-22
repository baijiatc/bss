package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IParametersService;
import cn.bjtc.view.ParametersView;

@RestController
@RequestMapping("parameters")
public class ParametersController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询产品参数信息",type=AspectType.CONTROLLER)
	public ApiReturn showActParameters(){
		 try {
			ApiParam param=findApiParam();
			 ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
			 int count=parameterservice.countAllParameterss(view);
			 List<?> parameters=parameterservice.findAllParameterss(view);
			 apiReturn.setCount(count);
			 apiReturn.setData(parameters);
		} catch (Exception e) {
			showServerError();
		}
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增产品参数信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddParameters(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
			parameterservice.saveParameters(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="编辑产品参数信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateParameters(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
			parameterservice.updateParameters(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditParameters(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ParametersView view=(ParametersView) ParamUtil.convertToView(param, ParametersView.class);
			List<?> parameters=parameterservice.findAllParameterss(view);
			apiReturn.setData(parameters);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IParametersService parameterservice;
}
