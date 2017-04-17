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
import cn.bjtc.service.IOrderService;
import cn.bjtc.view.OrderView;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showOrder(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		OrderView view = (OrderView) ParamUtil.convertToView(param, OrderView.class);
		int count = orderService.countAllOrder(view);
		List<?> Orders = orderService.findAllOrder(view);
		apiReturn.setCount(count);
		apiReturn.setData(Orders);
		return apiReturn;
	}
	@Autowired
	private IOrderService orderService;
}
