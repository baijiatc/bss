package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class RoleView extends Pagination {
	private Integer roleid;
	private String rolename;
	private Integer rolest;
	
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Integer getRolest() {
		return rolest;
	}
	public void setRolest(Integer rolest) {
		this.rolest = rolest;
	}
	public String getRolestStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ROLEST.toString(), String.valueOf(rolest));
	}
}
