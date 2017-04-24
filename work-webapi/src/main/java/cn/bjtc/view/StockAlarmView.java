package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class StockAlarmView  extends Pagination{
	private Integer alarmid;
	private Integer factcatid;
	private Integer objid;
	private Integer factorid;
	private Integer factvalueid;
	private Integer factunit;
	private Integer alarmst;
	
	public Integer getAlarmid() {
		return alarmid;
	}
	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}
	public Integer getFactcatid() {
		return factcatid;
	}
	public void setFactcatid(Integer factcatid) {
		this.factcatid = factcatid;
	}
	public String getFactcatidStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ALARMTYPE.toString(), String.valueOf(factcatid));
	}
	public Integer getObjid() {
		return objid;
	}
	public void setObjid(Integer objid) {
		this.objid = objid;
	}
	public Integer getFactorid() {
		return factorid;
	}
	public void setFactorid(Integer factorid) {
		this.factorid = factorid;
	}
	public String getFactoridStr() {
		return ApplicationDataManager.getFactorStringById(factorid);
	}
	public Integer getFactvalueid() {
		return factvalueid;
	}
	public void setFactvalueid(Integer factvalueid) {
		this.factvalueid = factvalueid;
	}
	public Integer getFactunit() {
		return factunit;
	}
	public void setFactunit(Integer factunit) {
		this.factunit = factunit;
	}
	public String getFactunitStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_FACTUNIT.toString(), String.valueOf(factunit));
	}
	public Integer getAlarmst() {
		return alarmst;
	}
	public void setAlarmst(Integer alarmst) {
		this.alarmst = alarmst;
	}
	public String getAlarmstStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ALARMST.toString(), String.valueOf(alarmst));
	}
}
