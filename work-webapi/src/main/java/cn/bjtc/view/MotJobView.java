package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class MotJobView extends Pagination{

	private Integer id;
	private Integer evtid;
	private Integer priority;
	private Integer isauto;
	private Integer executor;
	private Integer jobstats;
	private Integer begintime;
	private Integer endtime;
	private Integer finishtime;
 
	
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEvtid() {
		return evtid;
	}
	public void setEvtid(Integer evtid) {
		this.evtid = evtid;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getIsauto() {
		return isauto;
	}
	public void setIsauto(Integer isauto) {
		this.isauto = isauto;
	}
	public Integer getExecutor() {
		return executor;
	}
	public void setExecutor(Integer executor) {
		this.executor = executor;
	}
	public Integer getJobstats() {
		return jobstats;
	}
	public void setJobstats(Integer jobstats) {
		this.jobstats = jobstats;
	}
	public Integer getBegintime() {
		return begintime;
	}
	public void setBegintime(Integer begintime) {
		this.begintime = begintime;
	}
	public Integer getEndtime() {
		return endtime;
	}
	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}
	public Integer getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Integer finishtime) {
		this.finishtime = finishtime;
	}
	
 
	
	
	
 
}
