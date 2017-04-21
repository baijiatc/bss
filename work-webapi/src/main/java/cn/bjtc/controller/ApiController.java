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
import cn.bjtc.load.StartupLoader;
import cn.bjtc.service.IApiService;
import cn.bjtc.view.ApiView;

@RestController
@RequestMapping("api")
public class ApiController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询API信息",type=AspectType.CONTROLLER)
	public ApiReturn showApis(){
		try {
			ApiParam param = findApiParam();
			ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
			int count = apiService.countAllApis(view);
			List<?> privis = apiService.findAllApis(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增一个API",type=AspectType.CONTROLLER)
	public ApiReturn execAddApi(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
			apiService.saveApi(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新API信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateApi(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
			apiService.updateApi(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditApi(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			ApiView view = (ApiView) ParamUtil.convertToView(param, ApiView.class);
			List<?> privis = apiService.findAllApis(view);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="refresh", method=RequestMethod.POST)
	public ApiReturn refreshApiMap(){
		try {
			startupLoader.initApiMap();
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IApiService apiService;
	@Autowired
	private StartupLoader startupLoader;
}
