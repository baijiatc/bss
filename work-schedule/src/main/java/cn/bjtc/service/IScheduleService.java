package cn.bjtc.service;

import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;

public interface IScheduleService {
	
	public Integer countQrtzTriggers();
	
	public List<Map<String, Object>> getQrtzTriggers();
	
	public void pauseTrigger(String jobname, String jobgroup) throws SchedulerException;
	
	public void resumeTrigger(String jobname, String jobgroup) throws SchedulerException;
	
	public void execTrigger(String jobname, String jobgroup) throws SchedulerException;
	
}
