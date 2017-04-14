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
import cn.bjtc.service.IActyService;
import cn.bjtc.view.ActivityView;
 

@RestController
@RequestMapping("act")
public class ActyController  extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showActivitys(){
	   ApiParam param=ApiManager.getInstance().getParameters(request);
	   ActivityView  view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
	   int count=actyService.countAllActys(view);
	   List<?> acty=actyService.findAllActys(view);
	   apiReturn.setCount(count);
	   apiReturn.setData(acty);
	   return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddActivity(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
		actyService.saveActy(view);
		return apiReturn;
	}	
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateActivity(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
		actyService.updateActy(view);
		return apiReturn;
	}

    @RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditActivity(){
    	ApiParam param=ApiManager.getInstance().getParameters(request);
    	ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
        List<?> acty=actyService.findAllActys(view);
        apiReturn.setData(acty);
        return apiReturn;
    	
    	
    	
    	
    	
    }
	
	
	
	
	
	
	
	@Autowired
	private IActyService  actyService;
	
}
