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
import cn.bjtc.service.IStaffobjService;
import cn.bjtc.view.StaffobjView;

@RestController
@RequestMapping("supprs")
public class StaffobjController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showStaffobj(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
		int count = staffobjService.countAllStaffobj(view);
		List<?> staffobjs = staffobjService.findAllStaffobj(view);
		apiReturn.setCount(count);
		apiReturn.setData(staffobjs);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddStaffobj(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
		staffobjService.saveStaffobj(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateStaffobj(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
		staffobjService.updateStaffobj(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditStaffobj(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
		List<?> staffobjs = staffobjService.findAllStaffobj(view);
		apiReturn.setData(staffobjs);
		return apiReturn;
	}
	
	@Autowired
	private IStaffobjService staffobjService;
}
