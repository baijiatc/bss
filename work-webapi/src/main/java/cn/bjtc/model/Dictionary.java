package cn.bjtc.model;

public class Dictionary {
    private Integer dictid;
    private String dictname;//枚举名称
    private String dictval;//枚举值
    private Integer dicttype;//枚举类型
    private Integer dictst;//状态1-启用，0-停用
    
	public Integer getDictid() {
		return dictid;
	}
	public void setDictid(Integer dictid) {
		this.dictid = dictid;
	}
	public String getDictname() {
		return dictname;
	}
	public void setDictname(String dictname) {
		this.dictname = dictname;
	}
	public String getDictval() {
		return dictval;
	}
	public void setDictval(String dictval) {
		this.dictval = dictval;
	}
	public Integer getDicttype() {
		return dicttype;
	}
	public void setDicttype(Integer dicttype) {
		this.dicttype = dicttype;
	}
	public Integer getDictst() {
		return dictst;
	}
	public void setDictst(Integer dictst) {
		this.dictst = dictst;
	}
    
    
}
