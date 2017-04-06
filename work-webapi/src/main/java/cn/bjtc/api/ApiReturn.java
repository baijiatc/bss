package cn.bjtc.api;

import java.util.List;

public class ApiReturn {

	private int code = 1;
	private String message = "success";
	private int count = 0;
	private List<?> data;
	private long rtime = System.currentTimeMillis();
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public long getRtime() {
		return rtime;
	}
	public void setRtime(long rtime) {
		this.rtime = rtime;
	}
}
