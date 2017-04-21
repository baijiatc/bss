package cn.bjtc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.view.PrivilegeView;

@RestController
@RequestMapping("priv")
public class PrivilegeController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询权限定义信息",type=AspectType.CONTROLLER)
	public ApiReturn showPrivileges(){
		try {
			ApiParam param = findApiParam();
			PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
			int count = privilegeService.countAllPrivs(view);
			List<?> privis = privilegeService.findAllPrivs(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增权限定义",type=AspectType.CONTROLLER)
	public ApiReturn execAddPrivilege(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
			privilegeService.savePriv(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新权限定义信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdatePrivilege(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
			privilegeService.updatePriv(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditPrivilege(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			PrivilegeView view = (PrivilegeView) ParamUtil.convertToView(param, PrivilegeView.class);
			List<?> privis = privilegeService.findAllPrivs(view);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="role", method=RequestMethod.POST)
	@SysLogger(content="为角色设置权限",type=AspectType.CONTROLLER)
	public ApiReturn setRolePriv(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			List<Map<String, Object>> datas = param.getData();
			Map<String, Object> idMap = datas.get(0);
			Object who = idMap.get("who");
			Object what = idMap.get("what");
			Object how = idMap.get("how");
		
			privilegeService.deleteRoleAllPriv(who);//首先执行删除操作
			privilegeService.saveRolePriv(who, what, how);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="staff", method=RequestMethod.POST)
	@SysLogger(content="为员工分配权限",type=AspectType.CONTROLLER)
	public ApiReturn setStaffPriv(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			List<Map<String, Object>> datas = param.getData();
			Map<String, Object> idMap = datas.get(0);
			Object who = idMap.get("who");
			Object what = idMap.get("what");
			Object how = idMap.get("how");
		
			privilegeService.deleteStaffAllPriv(who);//首先执行删除操作
			privilegeService.saveStaffPriv(who, what, how);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="load", method=RequestMethod.POST)
	public ApiReturn loadObjectPriv(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			List<Map<String, Object>> datas = param.getData();
			Map<String, Object> idMap = datas.get(0);
			Object objid = idMap.get("objid");
			Object isRole = idMap.get("isRole");
			List<?> data = privilegeService.loadObjectPriv(objid, isRole);
			apiReturn.setData(data);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IPrivilegeService privilegeService;
}
