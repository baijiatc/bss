package cn.bjtc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.tools.ApplicationDataManager;
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
	
	@RequestMapping(value="role", method=RequestMethod.POST)
	public ApiReturn setRolePriv(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		List<Map<String, Object>> datas = param.getData();
		if(datas == null || datas.size() == 0){
			apiReturn.setCode(1);
			apiReturn.setMessage("缺少必要的参数！");
			return apiReturn;
		}
		Map<String, Object> idMap = datas.get(0);
		Object who = idMap.get("who");
		Object what = idMap.get("what");
		Object how = idMap.get("how");
		
		try {
			int delcount = privilegeService.deleteRoleAllPriv(who);//首先执行删除操作
			privilegeService.saveRolePriv(who, what, how);
		} catch (Exception e) {
			apiReturn.setCode(2);
			apiReturn.setMessage("服务器内部错误");
		}
		return apiReturn;
	}
	
	@RequestMapping(value="staff", method=RequestMethod.POST)
	public ApiReturn setStaffPriv(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		List<Map<String, Object>> datas = param.getData();
		if(datas == null || datas.size() == 0){
			apiReturn.setCode(1);
			apiReturn.setMessage("缺少必要的参数！");
			return apiReturn;
		}
		Map<String, Object> idMap = datas.get(0);
		Object who = idMap.get("who");
		Object what = idMap.get("what");
		Object how = idMap.get("how");
		
		try {
			int delcount = privilegeService.deleteStaffAllPriv(who);//首先执行删除操作
			privilegeService.saveStaffPriv(who, what, how);
		} catch (Exception e) {
			apiReturn.setCode(2);
			apiReturn.setMessage("服务器内部错误");
		}
		return apiReturn;
	}
	
	@RequestMapping(value="load", method=RequestMethod.POST)
	public ApiReturn loadObjectPriv(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		List<Map<String, Object>> datas = param.getData();
		if(datas == null || datas.size() == 0){
			apiReturn.setCode(1);
			apiReturn.setMessage("缺少必要的参数！");
			return apiReturn;
		}
		Map<String, Object> idMap = datas.get(0);
		Object objid = idMap.get("objid");
		Object isRole = idMap.get("isRole");
		try {
			List<?> data = privilegeService.loadObjectPriv(objid, isRole);
			apiReturn.setData(data);
		} catch (Exception e) {
			apiReturn.setCode(2);
			apiReturn.setMessage("服务器内部错误!");
		}
		return apiReturn;
	}
	
	@Autowired
	private IPrivilegeService privilegeService;
}
