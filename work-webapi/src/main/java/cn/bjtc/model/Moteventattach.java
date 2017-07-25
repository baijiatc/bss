package cn.bjtc.model;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;



public class Moteventattach {
	private Integer id;
	private Integer evtid;
	private Integer idxid;
	private String oprtchar;
	private String parmval;
	private Integer isactive;
	private Integer iscstm;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEvtid() {
		return evtid;
	}
	public void setEvtid(Integer evtid) {
		this.evtid = evtid;
	}
	public Integer getIdxid() {
		return idxid;
	}
	public void setIdxid(Integer idxid) {
		this.idxid = idxid;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	//public String getChnidStr() {
	//	return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_CHNAL.toString(), String.valueOf(chnid));
	//}
	public String getParmval() {
		return parmval;
	}
	public void setParmval(String parmval) {
		this.parmval = parmval;
	}
	public String getOprtchar() {
		return oprtchar;
	}
	public void setOprtchar(String oprtchar) {
		this.oprtchar = oprtchar;
	}
	
	public Integer getIscstm() {
		return iscstm;
	}
	public void setIscstm(Integer iscstm) {
		this.iscstm = iscstm;
	}
}