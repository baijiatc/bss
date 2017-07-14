package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;



public class MoteventschemeView extends Pagination {
	private Integer id;
	private Integer evtid;
	private Integer chnid;
	private String chnidStr;
	private Integer schmid;
	private String schmname;
	private String schmdesc;
	private Integer isactive;
	private Integer isautomatic;
	private String isautomaticStr;
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
	public Integer getChnid() {
		return chnid;
	}
	public void setChnid(Integer chnid) {
		this.chnid = chnid;
	}
	public Integer getSchmid() {
		return schmid;
	}
	public void setSchmid(Integer schmid) {
		this.schmid = schmid;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public String getChnidStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_CHNAL.toString(), String.valueOf(chnid));
	}
	public String getSchmname() {
		return schmname;
	}
	public void setSchmname(String schmname) {
		this.schmname = schmname;
	}
	public String getSchmdesc() {
		return schmdesc;
	}
	public void setSchmdesc(String schmdesc) {
		this.schmdesc = schmdesc;
	}
	public void setChnidStr(String chnidStr) {
		this.chnidStr = chnidStr;
	}
	public String getIsautomaticStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_AUTO.toString(), String.valueOf(isautomatic));
	}
}

