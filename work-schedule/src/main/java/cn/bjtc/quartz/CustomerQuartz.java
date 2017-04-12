package cn.bjtc.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.bjtc.quartz.async.TransCustomer;

public class CustomerQuartz extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		ScheduleManager.doJob(new TransCustomer());
	}

}
