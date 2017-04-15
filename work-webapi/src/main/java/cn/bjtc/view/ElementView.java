package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.tools.ApplicationDataManager;

public class ElementView extends Pagination {
	private Integer elemid;
	private String elemname;
	private String action;
	private Integer elemst;
	private String remark;
	
	public Integer getElemid() {
		return elemid;
	}
	public void setElemid(Integer elemid) {
		this.elemid = elemid;
	}
	public String getElemname() {
		return elemname;
	}
	public void setElemname(String elemname) {
		this.elemname = elemname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getElemst() {
		return elemst;
	}
	public void setElemst(Integer elemst) {
		this.elemst = elemst;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getElemstStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ELEMST.toString(), String.valueOf(elemst));
	}
}
