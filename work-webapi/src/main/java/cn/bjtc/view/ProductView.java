package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class ProductView extends Pagination{

	private Integer id;
	private String sourceid;//源标识
	private Integer fromsys;//来源平台
	private String prodname;
	private Integer catid;//类别
	private Integer brandid;
	private String  description;//商品详情
	private boolean checked;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;	}
	public String getSourceid() {
		return sourceid;
	}
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	public Integer getFromsys() {
		return fromsys;
	}
	public void setFromsys(Integer fromsys) {
		this.fromsys = fromsys;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public Integer getCatid() {
		return catid;
	}
	public void setCatid(Integer catid) {
		this.catid = catid;
	}
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromsysStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_FROMSYS.toString(), String.valueOf(fromsys));
	}


 
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
