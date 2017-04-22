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
import cn.bjtc.service.IStockAlarmService;
import cn.bjtc.view.StockAlarmView;

@RestController
@RequestMapping("alarm")
public class StockAlarmController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询预警信息",type=AspectType.CONTROLLER)
	public ApiReturn showStockAlarms(){
		try {
			ApiParam param = findApiParam();
			StockAlarmView view = (StockAlarmView) ParamUtil.convertToView(param, StockAlarmView.class);
			int count = stockAlarmService.countAllStockAlarms(view);
			List<?> privis = stockAlarmService.findAllStockAlarms(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增预警",type=AspectType.CONTROLLER)
	public ApiReturn execAddStockAlarm(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StockAlarmView view = (StockAlarmView) ParamUtil.convertToView(param, StockAlarmView.class);
			stockAlarmService.saveStockAlarm(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新预警信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateStockAlarm(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StockAlarmView view = (StockAlarmView) ParamUtil.convertToView(param, StockAlarmView.class);
			stockAlarmService.updateStockAlarm(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditStockAlarm(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			StockAlarmView view = (StockAlarmView) ParamUtil.convertToView(param, StockAlarmView.class);
			List<?> privis = stockAlarmService.findAllStockAlarms(view);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IStockAlarmService stockAlarmService;
}
