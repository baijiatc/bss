package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IMoneyflowService;
import cn.bjtc.view.MoneyflowView;

@RestController
@RequestMapping("flow")
public class MoneyflowController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询资金流水信息",type=AspectType.CONTROLLER)
	public ApiReturn showMoneyflow(){
		try {
			ApiParam param = findApiParam();
			MoneyflowView view = (MoneyflowView) ParamUtil.convertToView(param, MoneyflowView.class);
			int count = moneyflowService.countAllMoneyflow(view);
			List<?> moneyflows = moneyflowService.findAllMoneyflow(view);
			apiReturn.setCount(count);
			apiReturn.setData(moneyflows);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	@Autowired
	private IMoneyflowService moneyflowService;
}
