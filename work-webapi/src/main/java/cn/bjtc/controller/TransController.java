package cn.bjtc.controller;

import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.service.IScheduleService;

@RestController
@RequestMapping("trans")
public class TransController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showTriggers(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		Integer count = scheduleService.countQrtzTriggers();
		List<Map<String, Object>> data = scheduleService.getQrtzTriggers();
		apiReturn.setCount(count);
		apiReturn.setData(data);
		return apiReturn;
	}
	
	@RequestMapping(value="pause", method=RequestMethod.POST)
	public ApiReturn pauseTrigger(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		Map<String, Object> paramMap = param.getData().get(0);
		String jobname = (String) paramMap.get("jobname");
		String jobgroup = (String) paramMap.get("jobgroup");
		try {
			scheduleService.pauseTrigger(jobname,jobgroup);
		} catch (SchedulerException e) {
			apiReturn.setCode(1);
			apiReturn.setMessage("执行时出错！");
		}
		return apiReturn;
	}
	
	@RequestMapping(value="resume", method=RequestMethod.POST)
	public ApiReturn resumeTrigger(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		Map<String, Object> paramMap = param.getData().get(0);
		String jobname = (String) paramMap.get("jobname");
		String jobgroup = (String) paramMap.get("jobgroup");
		try {
			scheduleService.resumeTrigger(jobname, jobgroup);
		} catch (SchedulerException e) {
			apiReturn.setCode(1);
			apiReturn.setMessage("执行时出错！");
		}
		return apiReturn;
	}
	
	@RequestMapping(value="exec", method=RequestMethod.POST)
	public ApiReturn execTrigger(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		Map<String, Object> paramMap = param.getData().get(0);
		String jobname = (String) paramMap.get("jobname");
		String jobgroup = (String) paramMap.get("jobgroup");
		try {
			scheduleService.execTrigger(jobname, jobgroup);
		} catch (SchedulerException e) {
			apiReturn.setCode(1);
			apiReturn.setMessage("执行时出错！");
		}
		return apiReturn;
	}
	
	@Autowired
	private IScheduleService scheduleService;
}
