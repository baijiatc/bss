package cn.bjtc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.view.LoginView;

@RestController
public class DoLoginController extends BaseController {

	@RequestMapping(value="login",method=RequestMethod.POST)
	public ApiReturn login(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		LoginView view = (LoginView) ParamUtil.convertToView(param, LoginView.class);
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(view.getUname(), view.getUpass());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
		} catch (AuthenticationException e) {
			apiReturn.setCode(1);
			apiReturn.setMessage("用户名或密码错误！");
		}
		return apiReturn;
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public ApiReturn logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return apiReturn;
	}
}
