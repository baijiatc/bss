package cn.bjtc.service.impl;

import java.util.List;
import java.util.Map;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IScheduleDAO;
import cn.bjtc.service.IScheduleService;

@Service("scheduleService")
public class ScheduleServiceImpl implements IScheduleService {
	@Autowired
	private IScheduleDAO scheduleDAO;
	@Autowired
	private Scheduler scheduler;

    /**
     * @return
     * @see com.cube.service.SchedulerService#getQrtzTriggers()
     */
    public List<Map<String, Object>> getQrtzTriggers() {
        return scheduleDAO.getQrtzTriggers();
    }

    public Integer countQrtzTriggers() {
		return scheduleDAO.countQrtzTriggers();
	}

	public void pauseTrigger(String jobname, String jobgroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobname,jobgroup);
		scheduler.pauseJob(jobKey);
	}

	public void resumeTrigger(String jobname, String jobgroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobname,jobgroup);
		scheduler.resumeJob(jobKey);
	}

	public void execTrigger(String jobname, String jobgroup) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobname,jobgroup);
		scheduler.triggerJob(jobKey);
	}
}
