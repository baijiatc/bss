package cn.bjtc.model;

/**
 * @author Mr.wu
 *
 */
public class Idxparam {
	private Integer id;
	private String parmcode;
	private String parmname;
	private Integer parmtype;
	private Integer idxscope;
	private Double defaultvalue;
	private Integer creator;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParmcode() {
		return parmcode;
	}
	public void setParmcode(String parmcode) {
		this.parmcode = parmcode;
	}
	public String getParmname() {
		return parmname;
	}
	public void setParmname(String parmname) {
		this.parmname = parmname;
	}
	public Integer getParmtype() {
		return parmtype;
	}
	public void setParmtype(Integer parmtype) {
		this.parmtype = parmtype;
	}
	public Integer getIdxscope() {
		return idxscope;
	}
	public void setIdxscope(Integer idxscope) {
		this.idxscope = idxscope;
	}
	public Double getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(Double defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
}
