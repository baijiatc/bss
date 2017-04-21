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
import cn.bjtc.service.IStockService;
import cn.bjtc.view.StockDetView;
import cn.bjtc.view.StockView;

@RestController
@RequestMapping("stock")
public class StockController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询库存信息",type=AspectType.CONTROLLER)
	public ApiReturn showStocks(){
		try {
			ApiParam param = findApiParam();
			StockView view = (StockView) ParamUtil.convertToView(param, StockView.class);
			int count = stockService.countAllStocks(view);
			List<?> privis = stockService.findAllStocks(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="det", method=RequestMethod.POST)
	@SysLogger(content="查询库存明细信息",type=AspectType.CONTROLLER)
	public ApiReturn showStockDets(){
		try {
			ApiParam param = findApiParam();
			StockDetView view = (StockDetView) ParamUtil.convertToView(param, StockDetView.class);
			int count = stockService.countAllStockDets(view);
			List<?> privis = stockService.findAllStockDets(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IStockService stockService;
}
