package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class MenuView extends Pagination{

	private Integer menuid;
	private String menuname;
	private String url;
	private Integer parentid;
	private String icon;
	private Integer sort;
	private Integer menust;//1-启用，0-停用，-1删除
	private boolean checked;
	private boolean disabled;
	
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getMenust() {
		return menust;
	}
	public void setMenust(Integer menust) {
		this.menust = menust;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public String getMenustStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_MENUST.toString(), String.valueOf(menust));
	}
	
	public String getParentStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_PARENT.toString(), String.valueOf(parentid));
	}
}
