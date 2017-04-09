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
import cn.bjtc.service.IStaffService;
import cn.bjtc.view.StaffView;

@RestController
@RequestMapping("staff")
public class StaffController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showStaff(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
		int count = staffService.countAllStaff(view);
		List<?> staffs = staffService.findAllStaff(view);
		apiReturn.setCount(count);
		apiReturn.setData(staffs);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddStaff(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
		staffService.saveStaff(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateStaff(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
		staffService.updateStaff(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditStaff(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
		List<?> staffs = staffService.findAllStaff(view);
		apiReturn.setData(staffs);
		return apiReturn;
	}
	
	@Autowired
	private IStaffService staffService;
}
