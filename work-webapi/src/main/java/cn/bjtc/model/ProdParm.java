package cn.bjtc.model;

public class ProdParm {

	private Integer id;
	private Integer productid;
	private Integer paramid;
 	private String  paramvalue;
 	
	public String getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getParamid() {
		return paramid;
	}
	public void setParamid(Integer paramid) {
		this.paramid = paramid;
	}
//	public String getParamvalue() {
//		return paramvalue;
//	}
//	public void setParamvalue(String paramvalue) {
//		this.paramvalue = paramvalue;
//	}
	
}
