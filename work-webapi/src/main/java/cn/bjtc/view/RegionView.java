package cn.bjtc.view;

public class RegionView  extends Pagination{
	private Integer regionid;
	private String value;
	private Integer parentid;
	private Integer regionst;
	
	public Integer getRegionid() {
		return regionid;
	}
	public void setRegionid(Integer regionid) {
		this.regionid = regionid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getRegionst() {
		return regionst;
	}
	public void setRegionst(Integer regionst) {
		this.regionst = regionst;
	}
}
