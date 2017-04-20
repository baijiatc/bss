package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IRoleService;
import cn.bjtc.view.RoleView;

@RestController
@RequestMapping("role")
public class RoleController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询角色信息",type=AspectType.CONTROLLER)
	public ApiReturn showRoles(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		RoleView view = (RoleView) ParamUtil.convertToView(param, RoleView.class);
		int count = roleService.countAllRoles(view);
		List<?> privis = roleService.findAllRoles(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增角色",type=AspectType.CONTROLLER)
	public ApiReturn execAddRole(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		RoleView view = (RoleView) ParamUtil.convertToView(param, RoleView.class);
		roleService.saveRole(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新角色信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateRole(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		RoleView view = (RoleView) ParamUtil.convertToView(param, RoleView.class);
		roleService.updateRole(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditRole(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		RoleView view = (RoleView) ParamUtil.convertToView(param, RoleView.class);
		List<?> privis = roleService.findAllRoles(view);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@Autowired
	private IRoleService roleService;
}
