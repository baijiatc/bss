package cn.bjtc.view;

public class CatView extends Pagination{

	private Integer id;
	private String catname;
	private Integer parentid;//上级分类
	private String catlogo;
	private Integer catst;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getCatlogo() {
		return catlogo;
	}
	public void setCatlogo(String catlogo) {
		this.catlogo = catlogo;
	}
	public Integer getCatst() {
		return catst;
	}
	public void setCatst(Integer catst) {
		this.catst = catst;
	}
	
}
