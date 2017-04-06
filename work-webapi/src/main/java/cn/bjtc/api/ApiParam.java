package cn.bjtc.api;

import java.util.List;
import java.util.Map;

public class ApiParam {

	private Integer code;//请求的业务编码
	private List<Map<String,Object>> data;//请求参数json string
	private int psize = 10;//每页记录数
	private int pindex = 1;//当前页码
	private String ip = "0.0.0.0";//客户端IP地址
	private long rtime = System.currentTimeMillis();//客户端请求时间
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	public int getPsize() {
		return psize;
	}
	public void setPsize(int psize) {
		this.psize = psize;
	}
	public int getPindex() {
		return pindex;
	}
	public void setPindex(int pindex) {
		this.pindex = pindex;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getRtime() {
		return rtime;
	}
	public void setRtime(long rtime) {
		this.rtime = rtime;
	}
}
