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
import cn.bjtc.service.ISyslogService;
import cn.bjtc.view.SyslogView;
 
@RestController
@RequestMapping("sys")
public class SyslogController extends BaseController{

	@RequestMapping(value="all",method=RequestMethod.POST)
	public ApiReturn showSyslog(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		SyslogView  view=(SyslogView) ParamUtil.convertToView(param, SyslogView.class);
		int count=syslogService.countAllSys(view);
		List<?> sys=syslogService.findAllSys(view);
		apiReturn.setCount(count);
		apiReturn.setData(sys);
		return apiReturn;
	}
	
	
    @RequestMapping(value="get",method=RequestMethod.POST)
    public ApiReturn  execeditSyslog(){
    	ApiParam param=ApiManager.getInstance().getParameters(request);
    	SyslogView  view=(SyslogView) ParamUtil.convertToView(param, SyslogView.class);
		List<?> sys=syslogService.findAllSys(view);
		apiReturn.setData(sys);
		return apiReturn;
    	
    	
    	
    	
    }
	

	@Autowired
	private  ISyslogService  syslogService; 
	
}
