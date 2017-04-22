package cn.bjtc.model;

public class Factor {
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
}
