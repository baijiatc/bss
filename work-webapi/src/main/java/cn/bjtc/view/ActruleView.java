package cn.bjtc.view;

public class ActruleView  extends Pagination{

	private Integer id;
	private Integer actid;
	private Integer objtype;//如商品、品类
	private Integer objid;
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
	public Integer getObjtype() {
		return objtype;
	}
	public void setObjtype(Integer objtype) {
		this.objtype = objtype;
	}
	public Integer getObjid() {
		return objid;
	}
	public void setObjid(Integer objid) {
		this.objid = objid;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	
	
}
