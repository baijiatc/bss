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
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.view.PrivilegeView;

@RestController
@RequestMapping("priv")
public class PrivilegeController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showPrivileges(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
		int count = privilegeService.countAllPrivs(view);
		List<?> privis = privilegeService.findAllPrivs(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddPrivilege(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
		privilegeService.savePriv(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdatePrivilege(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
		privilegeService.updatePriv(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditPrivilege(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
		List<?> privis = privilegeService.findAllPrivs(view);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@Autowired
	private IPrivilegeService privilegeService;
}
