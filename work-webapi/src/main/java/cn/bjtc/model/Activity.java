package cn.bjtc.model;

public class Activity {
  private Integer id;
  private String  actname;
  private Integer acttype;//活动类型1-赠品，2-满减，3-满返，4-送积分，5-折扣
  private Integer actcat;//活动类别1-平台，2-商户
  private Integer begindt;//YYYYMMDD
  private Integer enddt;//YYYYMMDD
  private String  actdesc;
  private Integer creator;//0-平台，其他外键customer表商户ID
  private Integer actst;//1-新建(未开始)，2-已开始，3-已结束
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getActname() {
	return actname;
}
public void setActname(String actname) {
	this.actname = actname;
}
public Integer getActtype() {
	return acttype;
}
public void setActtype(Integer acttype) {
	this.acttype = acttype;
}
public Integer getActcat() {
	return actcat;
}
public void setActcat(Integer actcat) {
	this.actcat = actcat;
}
public Integer getBegindt() {
	return begindt;
}
public void setBegindt(Integer begindt) {
	this.begindt = begindt;
}
public Integer getEnddt() {
	return enddt;
}
public void setEnddt(Integer enddt) {
	this.enddt = enddt;
}
public String getActdesc() {
	return actdesc;
}
public void setActdesc(String actdesc) {
	this.actdesc = actdesc;
}
public Integer getCreator() {
	return creator;
}
public void setCreator(Integer creator) {
	this.creator = creator;
}
public Integer getActst() {
	return actst;
}
public void setActst(Integer actst) {
	this.actst = actst;
}
 
}
