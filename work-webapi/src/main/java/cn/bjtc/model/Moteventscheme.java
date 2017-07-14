package cn.bjtc.model;

public class Moteventscheme {
	private Integer id;
	private Integer evtid;
	private Integer chnid;
	private Integer schmid;
	private Integer isactive;
	private String schmname;
	private String schmdesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEvtid() {
		return evtid;
	}
	public void setEvtid(Integer evtid) {
		this.evtid = evtid;
	}
	public Integer getChnid() {
		return chnid;
	}
	public void setChnid(Integer chnid) {
		this.chnid = chnid;
	}
	public Integer getSchmid() {
		return schmid;
	}
	public void setSchmid(Integer schmid) {
		this.schmid = schmid;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public String getSchmname() {
		return schmname;
	}
	public void setSchmname(String schmname) {
		this.schmname = schmname;
	}
	public String getSchmdesc() {
		return schmdesc;
	}
	public void setSchmdesc(String schmdesc) {
		this.schmdesc = schmdesc;
	}
}
