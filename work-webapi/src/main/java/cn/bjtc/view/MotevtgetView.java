package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class MotevtgetView  extends Pagination{

	private Integer id;
	private Integer evtid;
	private Integer ltblid;
	private Integer hjoin;
	private Integer rtblid;
	private String onjoin;
	private Integer issingle;
	private String  hjoinStr;
	private String  ltblname;
	private String  rtblname;
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
	public Integer getLtblid() {
		return ltblid;
	}
	public void setLtblid(Integer ltblid) {
		this.ltblid = ltblid;
	}
	public Integer getHjoin() {
		return hjoin;
	}
	public void setHjoin(Integer hjoin) {
		this.hjoin = hjoin;
	}
	public Integer getRtblid() {
		return rtblid;
	}
	public void setRtblid(Integer rtblid) {
		this.rtblid = rtblid;
	}
	public Integer getIssingle() {
		return issingle;
	}
	public void setIssingle(Integer issingle) {
		this.issingle = issingle;
	}
	public String getHjoinStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_HJOIN.toString(), String.valueOf(hjoin));
	}
	public String getLtblname() {
		return ltblname;
	}
	public void setLtblname(String ltblname) {
		this.ltblname = ltblname;
	}
	public String getRtblname() {
		return rtblname;
	}
	public void setRtblname(String rtblname) {
		this.rtblname = rtblname;
	}
	public String getOnjoin() {
		return onjoin;
	}
	public void setOnjoin(String onjoin) {
		this.onjoin = onjoin;
	}
}
