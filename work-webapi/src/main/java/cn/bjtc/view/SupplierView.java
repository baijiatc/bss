package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class SupplierView extends Pagination {
	private Integer suppid;
	private String suppname;
	private Integer supplv;
	private String contact;
	private Integer mobile;
	private String telephone;
	private String address;
	private Integer isopenshop;
	public Integer getSuppid() {
		return suppid;
	}
	public void setSuppid(Integer suppid) {
		this.suppid = suppid;
	}
	public String getSuppname() {
		return suppname;
	}
	public void setSuppname(String suppname) {
		this.suppname = suppname;
	}
	public Integer getSupplv() {
		return supplv;
	}
	public void setSupplv(Integer supplv) {
		this.supplv = supplv;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsopenshop() {
		return isopenshop;
	}
	public void setIsopenshop(Integer isopenshop) {
		this.isopenshop = isopenshop;
	}
	public String getSupplvStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_SUPPLV.toString(), String.valueOf(supplv));
	}
	public String getIsopenshopStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ISOPENSHOP.toString(), String.valueOf(isopenshop));
	}
}
