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
import cn.bjtc.service.IStaffobjService;
import cn.bjtc.view.StaffobjView;

@RestController
@RequestMapping("supprs")
public class StaffobjController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询供应商与员工关系信息",type=AspectType.CONTROLLER)
	public ApiReturn showStaffobj(){
		try {
			ApiParam param = findApiParam();
			StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
			int count = staffobjService.countAllStaffobj(view);
			List<?> staffobjs = staffobjService.findAllStaffobj(view);
			apiReturn.setCount(count);
			apiReturn.setData(staffobjs);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增供应商与员工关系信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddStaffobj(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
			staffobjService.saveStaffobj(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="编辑供应商与员工关系信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateStaffobj(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
			staffobjService.updateStaffobj(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditStaffobj(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StaffobjView view = (StaffobjView) ParamUtil.convertToView(param, StaffobjView.class);
			List<?> staffobjs = staffobjService.findAllStaffobj(view);
			apiReturn.setData(staffobjs);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IStaffobjService staffobjService;
}
