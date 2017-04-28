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
import cn.bjtc.service.ICustomerService;
import cn.bjtc.view.CustomerView;

@RestController
@RequestMapping("cust")
public class CustomerController extends BaseController{
	
	@RequestMapping(value="all",method=RequestMethod.POST)
	@SysLogger(content="查询客户信息",type=AspectType.CONTROLLER)
	public ApiReturn showCustomers(){
		try {
			ApiParam param=findApiParam();
			CustomerView view=(CustomerView) ParamUtil.convertToView(param, CustomerView.class);
			int count =customerService.countAllCusts(view);
			List<?> custs=customerService.findAllCusts(view);
			apiReturn.setCount(count);
			apiReturn.setData(custs);
		} catch (Exception e) {
			showServerError();
		}
		return  apiReturn;
	}
	
	@RequestMapping(value="get",method=RequestMethod.POST)	
	public ApiReturn execeditCustomer(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			CustomerView view=(CustomerView) ParamUtil.convertToView(param, CustomerView.class);
			List<?> custs=customerService.findAllCusts(view);
			apiReturn.setData(custs);
		} catch (Exception e) {
			showServerError();
		}
		return  apiReturn;
	}
	
	@Autowired
	private ICustomerService  customerService;
}
