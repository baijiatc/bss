package cn.bjtc.view;

public class ActparamView  extends Pagination{

	private Integer id;
	private Integer actid;
	private Integer paramtype;//如数量、金额
	private Double  paramvalue;
	private Integer creator;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getActid() {
		return actid;
	}
	public void setActid(Integer actid) {
		this.actid = actid;
	}
	public Integer getParamtype() {
		return paramtype;
	}
	public void setParamtype(Integer paramtype) {
		this.paramtype = paramtype;
	}
	public Double getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(Double paramvalue) {
		this.paramvalue = paramvalue;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	
}
