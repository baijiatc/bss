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
import cn.bjtc.service.IMtJobService;
import cn.bjtc.view.MotJobView;

 

@RestController
@RequestMapping("motjob")
public class MotJobController  extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询任务信息",type=AspectType.CONTROLLER)
	public ApiReturn showMotJobs(){
	   try {
		ApiParam param=findApiParam();
		MotJobView  view=(MotJobView) ParamUtil.convertToView(param, MotJobView.class);
		   int count=mjobService.countAllMJob(view);
		   List<?> mtjob=mjobService.findAllMJob(view);;
		   apiReturn.setCount(count);
		   apiReturn.setData(mtjob);
	} catch (Exception e) {
		showServerError();
	}
	   return apiReturn;
	}
	
	 
	
//	@RequestMapping(value="update", method=RequestMethod.POST)
//	@SysLogger(content="更新活动信息",type=AspectType.CONTROLLER)
//	public ApiReturn execUpdateActivity(){
//		try {
//			ApiParam param=findApiParam();
//			ifParamDataIsEmpty(param);
//			ActivityView view=(ActivityView) ParamUtil.convertToView(param, ActivityView.class);
//			actyService.updateActy(view);
//		} catch (Exception e) {
//			showServerError();
//		}
//		return apiReturn;
//	}

    
	
	@Autowired
	private IMtJobService mjobService;
}
