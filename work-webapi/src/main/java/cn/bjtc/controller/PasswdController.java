package cn.bjtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IPasswdService;
import cn.bjtc.view.PasswdView;

@RestController
@RequestMapping("passwd")
public class PasswdController extends BaseController {
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdatePasswd(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		PasswdView view = (PasswdView) ParamUtil.convertToView(param, PasswdView.class);
		passwdService.updatePasswd(view);
		return apiReturn;
	}
	@Autowired
	private IPasswdService passwdService;
}
