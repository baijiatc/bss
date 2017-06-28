package cn.bjtc.view;

public class MotcolView  extends Pagination{

	private Integer id;
	private String evtname;
	private Integer biztype;
	private String evtdesc;
	private Integer evtstats;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEvtname() {
		return evtname;
	}
	public void setEvtname(String evtname) {
		this.evtname = evtname;
	}
	public Integer getBiztype() {
		return biztype;
	}
	public void setBiztype(Integer biztype) {
		this.biztype = biztype;
	}
	public String getEvtdesc() {
		return evtdesc;
	}
	public void setEvtdesc(String evtdesc) {
		this.evtdesc = evtdesc;
	}
	public Integer getEvtstats() {
		return evtstats;
	}
	public void setEvtstats(Integer evtstats) {
		this.evtstats = evtstats;
	}
}
