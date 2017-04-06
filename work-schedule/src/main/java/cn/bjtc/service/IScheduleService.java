package cn.bjtc.service;

import java.util.List;
import java.util.Map;

import org.quartz.CronExpression;

public interface IScheduleService {
	
	
	public List<Map<String, Object>> getQrtzTriggers();

    /**
     * 根据 Quartz Cron Expression 调试任务
     * 
     * @param name Quartz CronTrigger名称
     * @param group Quartz CronTrigger组
     * @param cronExpression Quartz Cron 表达式，如 "0/10 * * ? * * *"等
     */
    void schedule(String name, String group, String cronExpression);


    /**
     * 根据 Quartz Cron Expression 调试任务
     * 
     * @param name Quartz CronTrigger名称
     * @param group Quartz CronTrigger组
     * @param cronExpression Quartz CronExpression
     */
    void schedule(String name, String group, CronExpression cronExpression);
    
    
    /**
     * 
     * @param name Quartz CronTrigger名称
     * @param group Quartz CronTrigger组
     * @param cronExpression Quartz CronExpression
     */
    void schedule(String name, String group);



    void schedule(Map<String, Object> map);

    /**
     * 暂停触发器
     * 
     * @param triggerName 触发器名称
     */
    void pauseTrigger(String triggerName);

    /**
     * 暂停触发器
     * 
     * @param triggerName 触发器名称
     * @param group 触发器组
     */
    void pauseTrigger(String triggerName, String group);

    /**
     * 恢复触发器
     * 
     * @param triggerName 触发器名称
     */
    void resumeTrigger(String triggerName);

    /**
     * 恢复触发器
     * 
     * @param triggerName 触发器名称
     * @param group 触发器组
     */
    void resumeTrigger(String triggerName, String group);

    /**
     * 删除触发器
     * 
     * @param triggerName 触发器名称
     * @return
     */
    boolean removeTrigdger(String triggerName);

    /**
     * 删除触发器
     * 
     * @param triggerName 触发器名称
     * @param group 触发器组
     * @return
     */
    boolean removeTrigdger(String triggerName, String group);
}
