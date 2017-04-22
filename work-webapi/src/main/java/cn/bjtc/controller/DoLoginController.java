package cn.bjtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.annotation.SysLoggerAfter;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.common.WebConstants;
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.view.LoginView;
import cn.bjtc.view.PrivilegeView;

@RestController
public class DoLoginController extends BaseController {

	@RequestMapping(value="login",method=RequestMethod.POST)
	@SysLoggerAfter(content="登录系统",type=AspectType.CONTROLLER)
	public ApiReturn login(){
		try {
			ApiParam param = findApiParam();
			LoginView view = (LoginView) ParamUtil.convertToView(param, LoginView.class);
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(view.getUname(), view.getUpass());
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);
			} catch (AuthenticationException e) {
				apiReturn.setCode(1);
				apiReturn.setMessage("用户名或密码错误！");
			}
			findCurrentUserPrivs();
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	@SysLogger(content="登出系统",type=AspectType.CONTROLLER)
	public ApiReturn logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return apiReturn;
	}
	
	@RequestMapping(value="left/menu", method=RequestMethod.POST)
	public ApiReturn loadLeftMenu(){
		apiReturn.setData(ApplicationDataManager.SYSMENUS);
		return apiReturn;
	}
	
	private void findCurrentUserPrivs(){
		Object uname = WebUtils.getSessionAttribute(request, WebConstants.CURRENT_USER_NAME);
		Object uid = WebUtils.getSessionAttribute(request, WebConstants.CURRENT_USER_ID);
		List<PrivilegeView> views = privilegeService.findCurrentUserPrivs(uid);
		Map<String, Object> currentUserPrivMap = new HashMap<String, Object>(views.size());
		for(PrivilegeView view : views){
			currentUserPrivMap.put(view.getPrivname(), view);
		}
		String key = String.valueOf(uname)+String.valueOf(uid);
		ApplicationDataManager.USERPRIVS.put(key, currentUserPrivMap);
	}
	
	@Autowired
	private IPrivilegeService privilegeService;
}
