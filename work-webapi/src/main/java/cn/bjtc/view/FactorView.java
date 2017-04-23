package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class FactorView  extends Pagination{
	private Integer factid;
	private String factname;
	private String defaultval;
	private Integer defaultunit;
	
	public Integer getFactid() {
		return factid;
	}
	public void setFactid(Integer factid) {
		this.factid = factid;
	}
	public String getFactname() {
		return factname;
	}
	public void setFactname(String factname) {
		this.factname = factname;
	}
	public String getDefaultval() {
		return defaultval;
	}
	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
	}
	public Integer getDefaultunit() {
		return defaultunit;
	}
	public void setDefaultunit(Integer defaultunit) {
		this.defaultunit = defaultunit;
	}
	public String getDefaultunitStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_FACTUNIT.toString(), String.valueOf(defaultunit));
	}
}
