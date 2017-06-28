package cn.bjtc.model;

public class Motcol {

	private Integer id;
	private Integer tblid;
	private String colname;
	private String coldesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTblid() {
		return tblid;
	}
	public void setTblid(Integer tblid) {
		this.tblid = tblid;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getColdesc() {
		return coldesc;
	}
	public void setColdesc(String coldesc) {
		this.coldesc = coldesc;
	}
}
