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
import cn.bjtc.service.IMoneyflowService;
import cn.bjtc.view.MoneyflowView;

@RestController
@RequestMapping("flow")
public class MoneyflowController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showMoneyflow(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		MoneyflowView view = (MoneyflowView) ParamUtil.convertToView(param, MoneyflowView.class);
		int count = moneyflowService.countAllMoneyflow(view);
		List<?> moneyflows = moneyflowService.findAllMoneyflow(view);
		apiReturn.setCount(count);
		apiReturn.setData(moneyflows);
		return apiReturn;
	}
	@Autowired
	private IMoneyflowService moneyflowService;
}
