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
import cn.bjtc.service.IActyService;
import cn.bjtc.view.ActivityView;
 

@RestController
@RequestMapping("act")
public class ActyController  extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询活动信息",type=AspectType.CONTROLLER)
	public ApiReturn showActivitys(){
	   try {
		ApiParam param=findApiParam();
		   ActivityView  view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
		   int count=actyService.countAllActys(view);
		   List<?> acty=actyService.findAllActys(view);
		   apiReturn.setCount(count);
		   apiReturn.setData(acty);
	} catch (Exception e) {
		showServerError();
	}
	   return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增活动信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddActivity(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
			actyService.saveActy(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}	
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新活动信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateActivity(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
			actyService.updateActy(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}

    @RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditActivity(){
    	try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
			List<?> acty=actyService.findAllActys(view);
			apiReturn.setData(acty);
		} catch (Exception e) {
			showServerError();
		}
        return apiReturn;
    }
	
	@Autowired
	private IActyService  actyService;
}
