package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class ParametersView extends Pagination{

	private Integer id;
	private String paramname;
	private String paramdesc;
	private Integer paramtype;
	private Integer paramst;
	
	private String paramvalue;
	
	
	public String getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}
	private boolean checked;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParamname() {
		return paramname;
	}
	public void setParamname(String paramname) {
		this.paramname = paramname;
	}
	public String getParamdesc() {
		return paramdesc;
	}
	public void setParamdesc(String paramdesc) {
		this.paramdesc = paramdesc;
	}
	public Integer getParamtype() {
		return paramtype;
	}
	public void setParamtype(Integer paramtype) {
		this.paramtype = paramtype;
	}
	public Integer getParamst() {
		return paramst;
	}
	public void setParamst(Integer paramst) {
		this.paramst = paramst;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getParamtypeStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_PARAMTYPE.toString(), String.valueOf(paramtype));
	}
	public String getParamstStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_PARAMST.toString(), String.valueOf(paramst));
	}
}
