package cn.bjtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IPasswdService;
import cn.bjtc.view.PasswdView;

@RestController
@RequestMapping("passwd")
public class PasswdController extends BaseController {
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="修改密码",type=AspectType.CONTROLLER)
	public ApiReturn execUpdatePasswd(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			PasswdView view = (PasswdView) ParamUtil.convertToView(param, PasswdView.class);
			passwdService.updatePasswd(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	@Autowired
	private IPasswdService passwdService;
}
