package cn.bjtc.view;

public class ParametersView extends Pagination{

	private Integer id;
	private String paramname;
	private String paramdesc;
	private Integer paramtype;
	private Integer paramst;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParamname() {
		return paramname;
	}
	public void setParamname(String paramname) {
		this.paramname = paramname;
	}
	public String getParamdesc() {
		return paramdesc;
	}
	public void setParamdesc(String paramdesc) {
		this.paramdesc = paramdesc;
	}
	public Integer getParamtype() {
		return paramtype;
	}
	public void setParamtype(Integer paramtype) {
		this.paramtype = paramtype;
	}
	public Integer getParamst() {
		return paramst;
	}
	public void setParamst(Integer paramst) {
		this.paramst = paramst;
	}
}
