package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class ApiView extends Pagination {
	private Integer apiid;
	private Integer code;
	private String apiname;
	private String apiurl;
	private String retype;
	private Integer apist;
	
	public Integer getApiid() {
		return apiid;
	}
	public void setApiid(Integer apiid) {
		this.apiid = apiid;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getApiname() {
		return apiname;
	}
	public void setApiname(String apiname) {
		this.apiname = apiname;
	}
	public String getApiurl() {
		return apiurl;
	}
	public void setApiurl(String apiurl) {
		this.apiurl = apiurl;
	}
	public String getRetype() {
		return retype;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	public Integer getApist() {
		return apist;
	}
	public void setApist(Integer apist) {
		this.apist = apist;
	}
	public String getApistStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_APIST.toString(),String.valueOf(apist));
	}
}
