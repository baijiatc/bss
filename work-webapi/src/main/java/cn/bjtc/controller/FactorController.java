package cn.bjtc.controller;

import java.util.ArrayList;
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
import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.service.IFactorService;
import cn.bjtc.view.FactorView;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("factor")
public class FactorController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询预警因子信息",type=AspectType.CONTROLLER)
	public ApiReturn showFactors(){
		try {
			ApiParam param = findApiParam();
			FactorView view = (FactorView) ParamUtil.convertToView(param, FactorView.class);
			int count = factorService.countAllFactors(view);
			List<?> privis = factorService.findAllFactors(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增预警因子",type=AspectType.CONTROLLER)
	public ApiReturn execAddFactor(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			FactorView view = (FactorView) ParamUtil.convertToView(param, FactorView.class);
			factorService.saveFactor(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新预警因子信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateFactor(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			FactorView view = (FactorView) ParamUtil.convertToView(param, FactorView.class);
			factorService.updateFactor(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditFactor(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			FactorView view = (FactorView) ParamUtil.convertToView(param, FactorView.class);
			List<?> privis = factorService.findAllFactors(view);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="combox", method=RequestMethod.POST)
	public ApiReturn findFactorFromMem(){
		List<JSONObject> jsonLst = new ArrayList<JSONObject>();
		for(String key : ApplicationDataManager.SYSFACTORS.keySet()){
			JSONObject json = new JSONObject();
			json.put("value", ApplicationDataManager.SYSFACTORS.get(key));
			json.put("label", key);
			jsonLst.add(json);
		}
		apiReturn.setData(jsonLst);
		return apiReturn;
	}
	
	@Autowired
	private IFactorService factorService;
}
