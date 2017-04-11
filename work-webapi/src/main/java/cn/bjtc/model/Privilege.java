package cn.bjtc.model;

public class Privilege {

	private Integer privid;
	private String privname;
	private Integer privtype;
	private Integer privcat;
	private String privdesc;
	private Integer privst;
	
	public Integer getPrivid() {
		return privid;
	}
	public void setPrivid(Integer privid) {
		this.privid = privid;
	}
	public String getPrivname() {
		return privname;
	}
	public void setPrivname(String privname) {
		this.privname = privname;
	}
	public Integer getPrivtype() {
		return privtype;
	}
	public void setPrivtype(Integer privtype) {
		this.privtype = privtype;
	}
	public Integer getPrivcat() {
		return privcat;
	}
	public void setPrivcat(Integer privcat) {
		this.privcat = privcat;
	}
	public String getPrivdesc() {
		return privdesc;
	}
	public void setPrivdesc(String privdesc) {
		this.privdesc = privdesc;
	}
	public Integer getPrivst() {
		return privst;
	}
	public void setPrivst(Integer privst) {
		this.privst = privst;
	}
}
