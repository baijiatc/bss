package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IActparamService;
import cn.bjtc.view.ActparamView;

@RestController
@RequestMapping("actparam")
public class ActparamController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showActparams(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActparamView view=(ActparamView) ParamUtil.convertToView(param, ActparamView.class);
		int count=actparamService.countAllActparams(view);
		List<?> actparams=actparamService.findAllActparams(view);
		apiReturn.setCount(count);
		apiReturn.setData(actparams);
		return apiReturn;
		
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddActparam(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActparamView view=(ActparamView) ParamUtil.convertToView(param, ActparamView.class);
		actparamService.saveActparam(view);
		return apiReturn;
		
	} 
	
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateActparam(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActparamView view=(ActparamView) ParamUtil.convertToView(param, ActparamView.class);
		actparamService.updateActparam(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditActparam(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActparamView view=(ActparamView) ParamUtil.convertToView(param, ActparamView.class);
		List<?> actparams=actparamService.findAllActparams(view);
		apiReturn.setData(actparams);
		return apiReturn;	
	}
		
	@Autowired
	private IActparamService actparamService;
}
