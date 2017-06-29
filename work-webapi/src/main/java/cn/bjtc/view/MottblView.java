package cn.bjtc.view;


public class MottblView  extends Pagination{

	private Integer id;
	private String tblname;
	private String tbldesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTblname() {
		return tblname;
	}
	public void setTblname(String tblname) {
		this.tblname = tblname;
	}
	public String getTbldesc() {
		return tbldesc;
	}
	public void setTbldesc(String tbldesc) {
		this.tbldesc = tbldesc;
	}
}
