package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IDepartService;
import cn.bjtc.view.DepartView;

@RestController
@RequestMapping("depart")
public class DepartController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showDept(){
		try {
			ApiParam param = findApiParam();
			DepartView view = (DepartView) ParamUtil.convertToView(param, DepartView.class);
			int count = departService.countAllDepart(view);
			List<?> depts = departService.findAllDepart(view);
			apiReturn.setCount(count);
			apiReturn.setData(depts);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddDept(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			DepartView view = (DepartView) ParamUtil.convertToView(param, DepartView.class);
			departService.saveDepart(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateDept(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			DepartView view = (DepartView) ParamUtil.convertToView(param, DepartView.class);
			departService.updateDepart(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditDept(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			DepartView view = (DepartView) ParamUtil.convertToView(param, DepartView.class);
			List<?> depts = departService.findAllDepart(view);
			apiReturn.setData(depts);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IDepartService departService;
}
