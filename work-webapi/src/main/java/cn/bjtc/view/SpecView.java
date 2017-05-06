package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class SpecView extends Pagination{

	private Integer id;
	private String specname;
	private String specdesc;
	private Integer spectype;
	private Integer specst;
	
	private boolean checked;
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecname() {
		return specname;
	}
	public void setSpecname(String specname) {
		this.specname = specname;
	}
	public String getSpecdesc() {
		return specdesc;
	}
	public void setSpecdesc(String specdesc) {
		this.specdesc = specdesc;
	}
	public Integer getSpectype() {
		return spectype;
	}
	public void setSpectype(Integer spectype) {
		this.spectype = spectype;
	}
	public Integer getSpecst() {
		return specst;
	}
	public void setSpecst(Integer specst) {
		this.specst = specst;
	}
	public String getSpectypeStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_SPECTYPE.toString(), String.valueOf(spectype));
	}
	public String getSpecstStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_SPECST.toString(), String.valueOf(specst));
	}
}
