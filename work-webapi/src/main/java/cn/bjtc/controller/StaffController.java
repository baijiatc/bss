package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		try {
			ApiParam param = findApiParam();
			StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
			int count = staffService.countAllStaff(view);
			List<?> staffs = staffService.findAllStaff(view);
			apiReturn.setCount(count);
			apiReturn.setData(staffs);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddStaff(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
			staffService.saveStaff(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateStaff(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
			staffService.updateStaff(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditStaff(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StaffView view = (StaffView) ParamUtil.convertToView(param, StaffView.class);
			List<?> staffs = staffService.findAllStaff(view);
			apiReturn.setData(staffs);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IStaffService staffService;
}
