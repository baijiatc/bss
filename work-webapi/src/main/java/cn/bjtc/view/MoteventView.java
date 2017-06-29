package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;


public class MoteventView extends Pagination {
	private Integer id;
	private String evtname;
	private Integer biztype;
	private String evtdesc;
	private Integer evtstats;
	private String biztypeStr;
	private String evtstatStr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEvtname() {
		return evtname;
	}
	public void setEvtname(String evtname) {
		this.evtname = evtname;
	}
	public Integer getBiztype() {
		return biztype;
	}
	public void setBiztype(Integer biztype) {
		this.biztype = biztype;
	}
	public String getEvtdesc() {
		return evtdesc;
	}
	public void setEvtdesc(String evtdesc) {
		this.evtdesc = evtdesc;
	}
	public Integer getEvtstats() {
		return evtstats;
	}
	public void setEvtstats(Integer evtstats) {
		this.evtstats = evtstats;
	}
	public String getBiztypeStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_BIZTYPE.toString(), String.valueOf(biztype));
	}
	public String getEvtstatStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_EVTSTATS.toString(), String.valueOf(evtstats));
	}
}
