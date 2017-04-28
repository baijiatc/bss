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
import cn.bjtc.service.IActawardsService;
import cn.bjtc.view.ActawardsView;

@RestController
@RequestMapping("actawd")
public class ActawardsController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询活动奖励信息",type=AspectType.CONTROLLER)
	public ApiReturn showActawards(){
		try {
			ApiParam param=findApiParam();
			ActawardsView view=(ActawardsView) ParamUtil.convertToView(param, ActawardsView.class);
			int count=actawardsService.countAllActawards(view);
			List<?> actawards=actawardsService.findAllActawards(view);
			apiReturn.setCount(count);
			apiReturn.setData(actawards);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增活动奖励信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddActawards(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActawardsView view=(ActawardsView) ParamUtil.convertToView(param, ActawardsView.class);
			actawardsService.saveActawards(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新活动奖励信息",type=AspectType.CONTROLLER)
    public ApiReturn execUpdateActawards(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActawardsView view=(ActawardsView) ParamUtil.convertToView(param, ActawardsView.class);
			actawardsService.updateActawards(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	} 
    
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditActawards(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActawardsView view=(ActawardsView) ParamUtil.convertToView(param, ActawardsView.class);
			List<?> actawards=actawardsService.findAllActawards(view);
			apiReturn.setData(actawards);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
    
	@Autowired
	private IActawardsService actawardsService;
}
