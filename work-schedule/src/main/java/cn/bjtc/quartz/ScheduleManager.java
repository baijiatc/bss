package cn.bjtc.quartz;

import cn.bjtc.quartz.async.IJob;

public class ScheduleManager {
	
	public static void doJob(IJob job){
		job.execute();
	}
}
