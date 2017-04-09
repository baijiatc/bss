package cn.bjtc.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class OrderQuartz extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("执行订单数据传输!!!");
	}

}
