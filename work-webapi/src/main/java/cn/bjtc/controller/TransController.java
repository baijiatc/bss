package cn.bjtc.controller;

import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IScheduleService;

@RestController
@RequestMapping("trans")
public class TransController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询计划任务信息",type=AspectType.CONTROLLER)
	public ApiReturn showTriggers(){
		try {
			Integer count = scheduleService.countQrtzTriggers();
			List<Map<String, Object>> data = scheduleService.getQrtzTriggers();
			apiReturn.setCount(count);
			apiReturn.setData(data);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="pause", method=RequestMethod.POST)
	@SysLogger(content="暂停计划任务",type=AspectType.CONTROLLER)
	public ApiReturn pauseTrigger(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> paramMap = param.getData().get(0);
			String jobname = (String) paramMap.get("jobname");
			String jobgroup = (String) paramMap.get("jobgroup");
			scheduleService.pauseTrigger(jobname,jobgroup);
		} catch (SchedulerException e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="resume", method=RequestMethod.POST)
	@SysLogger(content="恢复计划任务",type=AspectType.CONTROLLER)
	public ApiReturn resumeTrigger(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> paramMap = param.getData().get(0);
			String jobname = (String) paramMap.get("jobname");
			String jobgroup = (String) paramMap.get("jobgroup");
			scheduleService.resumeTrigger(jobname, jobgroup);
		} catch (SchedulerException e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="exec", method=RequestMethod.POST)
	@SysLogger(content="手动执行计划任务",type=AspectType.CONTROLLER)
	public ApiReturn execTrigger(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> paramMap = param.getData().get(0);
			String jobname = (String) paramMap.get("jobname");
			String jobgroup = (String) paramMap.get("jobgroup");
			scheduleService.execTrigger(jobname, jobgroup);
		} catch (SchedulerException e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IScheduleService scheduleService;
}
