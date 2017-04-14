package cn.bjtc.view;

public class SysParamView extends Pagination {
	private Integer paramid;
	private String paramname;
	private String paramvalue;
	private String remark;
	public Integer getParamid() {
		return paramid;
	}
	public void setParamid(Integer paramid) {
		this.paramid = paramid;
	}
	public String getParamname() {
		return paramname;
	}
	public void setParamname(String paramname) {
		this.paramname = paramname;
	}
	public String getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
