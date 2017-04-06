package cn.bjtc.model;

import java.io.Serializable;

public class Qrtz_Job_Details implements Serializable {

	private String sched_name;
	private String job_name;
	private String job_group;
	private String description;
	private String job_class_name;
	private String is_durable;
	private String is_nonconcurrent;
	private String is_update_data;
	private String requests_recovery;
	public String getSched_name() {
		return sched_name;
	}
	public void setSched_name(String sched_name) {
		this.sched_name = sched_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_group() {
		return job_group;
	}
	public void setJob_group(String job_group) {
		this.job_group = job_group;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJob_class_name() {
		return job_class_name;
	}
	public void setJob_class_name(String job_class_name) {
		this.job_class_name = job_class_name;
	}
	public String isIs_durable() {
		return is_durable;
	}
	public void setIs_durable(String is_durable) {
		this.is_durable = is_durable;
	}
	public String isIs_nonconcurrent() {
		return is_nonconcurrent;
	}
	public void setIs_nonconcurrent(String is_nonconcurrent) {
		this.is_nonconcurrent = is_nonconcurrent;
	}
	public String isIs_update_data() {
		return is_update_data;
	}
	public void setIs_update_data(String is_update_data) {
		this.is_update_data = is_update_data;
	}
	public String isRequests_recovery() {
		return requests_recovery;
	}
	public void setRequests_recovery(String requests_recovery) {
		this.requests_recovery = requests_recovery;
	}
	
}
