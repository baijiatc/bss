package cn.bjtc.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.quartz.CronExpression;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
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
    @Autowired
    private JobDetail jobDetail;

    private static final String NULLSTRING = null;
    private static final Date NULLDATE = null;

    /**
     * 
     * @param name
     * @param group
     * @param cronExpression
     * @see com.cube.service.SchedulerService#schedule(java.lang.String, java.lang.String,
     *      java.lang.String)
     */
    public void schedule(String name, String group, String cronExpression) {
    	try {
			schedule(name, group, new CronExpression(cronExpression));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    /**
     * @param name
     * @param group
     * @param cronExpression
     * @see com.cube.service.SchedulerService#schedule(java.lang.String, java.lang.String,
     *      org.quartz.CronExpression)
     */
    public void schedule(String name, String group, CronExpression cronExpression) {

        if (name == null || name.trim().equals("")) {
            name = UUID.randomUUID().toString();
        }

        CronTriggerImpl trigger = new CronTriggerImpl();
        trigger.setCronExpression(cronExpression);

        TriggerKey triggerKey = new TriggerKey(name, group);

        trigger.setJobName(jobDetail.getKey().getName());
        trigger.setKey(triggerKey);

        try {
            scheduler.addJob(jobDetail, true);
            if (scheduler.checkExists(triggerKey)) {
                scheduler.rescheduleJob(triggerKey, trigger);
            } else {
                scheduler.scheduleJob(trigger);
            }
        } catch (SchedulerException e) {
            throw new IllegalArgumentException(e);
        }

    }

    /**
     * @param map
     * @see com.cube.service.SchedulerService#schedule(java.util.Map)
     */
    public void schedule(Map<String, Object> map) {
        // TODO Auto-generated method stub

    }

    /**
     * @param triggerName
     * @see com.cube.service.SchedulerService#pauseTrigger(java.lang.String)
     */
    public void pauseTrigger(String triggerName) {
        // TODO Auto-generated method stub

    }

    /**
     * @param triggerName
     * @param group
     * @see com.cube.service.SchedulerService#pauseTrigger(java.lang.String, java.lang.String)
     */
    public void pauseTrigger(String triggerName, String group) {

        try {
            scheduler.pauseTrigger(new TriggerKey(triggerName, group));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param triggerName
     * @see com.cube.service.SchedulerService#resumeTrigger(java.lang.String)
     */
    public void resumeTrigger(String triggerName) {
        // TODO Auto-generated method stub

    }

    /**
     * @param triggerName
     * @param group
     * @see com.cube.service.SchedulerService#resumeTrigger(java.lang.String, java.lang.String)
     */
    public void resumeTrigger(String triggerName, String group) {

        TriggerKey triggerKey = new TriggerKey(triggerName, group);

        try {
            scheduler.resumeTrigger(triggerKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param triggerName
     * @return
     * @see com.cube.service.SchedulerService#removeTrigdger(java.lang.String)
     */
    public boolean removeTrigdger(String triggerName) {
        return removeTrigdger(triggerName, NULLSTRING);

    }

    /**
     * @param triggerName
     * @param group
     * @return
     * @see com.cube.service.SchedulerService#removeTrigdger(java.lang.String, java.lang.String)
     */
    public boolean removeTrigdger(String triggerName, String group) {
        TriggerKey triggerKey = new TriggerKey(triggerName, group);
        try {
            scheduler.pauseTrigger(triggerKey);// 停止触发器
            return scheduler.unscheduleJob(triggerKey);// 移除触发器
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     * @see com.cube.service.SchedulerService#getQrtzTriggers()
     */
    public List<Map<String, Object>> getQrtzTriggers() {
        return scheduleDAO.getQrtzTriggers();
    }

    /**
     * @param name
     * @param group
     * @see com.cube.service.SchedulerService#schedule(java.lang.String, java.lang.String)
     */
    public void schedule(String name, String group) {
        schedule(name, group, NULLSTRING);
    }
}
