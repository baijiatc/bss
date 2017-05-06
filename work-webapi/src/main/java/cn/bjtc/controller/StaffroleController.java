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
import cn.bjtc.service.IRoleService;
import cn.bjtc.service.IStaffroleService;
import cn.bjtc.view.ElementView;
import cn.bjtc.view.StaffroleView;

@RestController
@RequestMapping("staffrole")
public class StaffroleController extends BaseController {

	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="分配员工角色信息",type=AspectType.CONTROLLER)
	public ApiReturn execcreateStaffrole(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Object roleids = param.getData().get(0).get("roleid");
			Object staffid = param.getData().get(0).get("staffid");
			staffrolefService.deleteById(staffid);
			if(roleids !=null && roleids != ""){
				staffrolefService.createStaffrole(staffid,roleids);
			}
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="getStaffRole", method=RequestMethod.POST)
	public ApiReturn findAllStaffRole(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> staffIdMap = param.getData().get(0);
			Object staffid = staffIdMap.get("sid");
			List<?> roles = rolefService.findAllRoleByStaffId(staffid);
			apiReturn.setData(roles);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IStaffroleService staffrolefService;
	@Autowired
	private IRoleService rolefService;
}
