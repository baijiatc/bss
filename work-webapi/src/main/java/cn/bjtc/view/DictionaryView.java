package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class DictionaryView extends Pagination {

    private Integer dictid;
    private String dictname;//枚举名称
    private String dictval;//枚举值
    private Integer dicttype;
    private Integer dictst;//状态

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
	public String getDictstStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_DICTST.toString(), String.valueOf(dictst));
	}
    
}
