package cn.bjtc.view;

public class SyslogView extends Pagination{
	  private Integer id;//
	  private Integer logtype;
	  private Integer operator;// 
	  private Integer privid;//操作人
	  private Integer createtime;// 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLogtype() {
		return logtype;
	}
	public void setLogtype(Integer logtype) {
		this.logtype = logtype;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public Integer getPrivid() {
		return privid;
	}
	public void setPrivid(Integer privid) {
		this.privid = privid;
	}
	public Integer getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	 
}
