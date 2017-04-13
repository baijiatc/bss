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
import cn.bjtc.service.IStockService;
import cn.bjtc.view.StockDetView;
import cn.bjtc.view.StockView;

@RestController
@RequestMapping("stock")
public class StockController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showStocks(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StockView view = (StockView) ParamUtil.convertToView(param, StockView.class);
		int count = stockService.countAllStocks(view);
		List<?> privis = stockService.findAllStocks(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@RequestMapping(value="det", method=RequestMethod.POST)
	public ApiReturn showStockDets(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		StockDetView view = (StockDetView) ParamUtil.convertToView(param, StockDetView.class);
		int count = stockService.countAllStockDets(view);
		List<?> privis = stockService.findAllStockDets(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@Autowired
	private IStockService stockService;
}
