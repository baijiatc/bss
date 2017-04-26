package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class IndexesView extends Pagination {
	private Integer id;
	private String idxcode;
	private String idxname;
	private Integer idxorder;
	private Integer idxtype;
	private Integer idxscope;
	private String idxformula;
	private Integer isdisplay;
	private Integer validdt;
	private Integer invaliddt;
	private Integer creator;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdxcode() {
		return idxcode;
	}
	public void setIdxcode(String idxcode) {
		this.idxcode = idxcode;
	}
	public String getIdxname() {
		return idxname;
	}
	public void setIdxname(String idxname) {
		this.idxname = idxname;
	}
	public Integer getIdxorder() {
		return idxorder;
	}
	public void setIdxorder(Integer idxorder) {
		this.idxorder = idxorder;
	}
	public Integer getIdxtype() {
		return idxtype;
	}
	public void setIdxtype(Integer idxtype) {
		this.idxtype = idxtype;
	}
	public Integer getIdxscope() {
		return idxscope;
	}
	public void setIdxscope(Integer idxscope) {
		this.idxscope = idxscope;
	}
	public String getIdxformula() {
		return idxformula;
	}
	public void setIdxformula(String idxformula) {
		this.idxformula = idxformula;
	}
	public Integer getIsdisplay() {
		return isdisplay;
	}
	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}
	public Integer getValiddt() {
		return validdt;
	}
	public void setValiddt(Integer validdt) {
		this.validdt = validdt;
	}
	public Integer getInvaliddt() {
		return invaliddt;
	}
	public void setInvaliddt(Integer invaliddt) {
		this.invaliddt = invaliddt;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public String getIsdisplayStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ISDISPLAY.toString(), String.valueOf(isdisplay));
	}
}
