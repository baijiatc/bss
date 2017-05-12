package cn.bjtc.model;

/**
 * @author Mr.wu
 *
 */
public class Depart {

	private Integer departid;
	private String departname;
	private Integer leader;
	private Integer parentid;
	private String address;
	private String telephone;
	private Integer departst;
	private String parentStr;
	private String staffname;
	public Integer getDepartid() {
		return departid;
	}
	public void setDepartid(Integer departid) {
		this.departid = departid;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public Integer getLeader() {
		return leader;
	}
	public void setLeader(Integer leader) {
		this.leader = leader;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getDepartst() {
		return departst;
	}
	public void setDepartst(Integer departst) {
		this.departst = departst;
	}
	public String getParentStr() {
		return parentStr;
	}
	public void setParentStr(String parentStr) {
		this.parentStr = parentStr;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
}
