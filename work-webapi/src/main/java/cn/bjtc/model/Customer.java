package cn.bjtc.model;

public class Customer {
 private Integer cstmid;
 private Integer cstmno;//客户号
 private String  cstmname;//客户姓名
 private String  certno;//证件号码 会员为身份证号，商户为企业资质证件号码
 private Integer certtype;//证件类型1-身份证，2-营业执照
 private Long     mobile;
 private Integer gender;//性别
 private Integer birthday;//YYYYMMDD
 private Integer cstmlevel;
 private String  cstmphoto;
 private String  hobby;
 private String  email;
 private Integer cstmtype;// 客户类型1-会员，2-商户
 private Integer regtime;//注册时间 YYYYMMDD
 private Integer cstmst;//客户状态 1-正常，2-睡眠，3-注销
 
public Integer getCstmid() {
	return cstmid;
}
public void setCstmid(Integer cstmid) {
	this.cstmid = cstmid;
}
public Integer getCstmno() {
	return cstmno;
}
public void setCstmno(Integer cstmno) {
	this.cstmno = cstmno;
}
public String getCstmname() {
	return cstmname;
}
public void setCstmname(String cstmname) {
	this.cstmname = cstmname;
}
public String getCertno() {
	return certno;
}
public void setCertno(String certno) {
	this.certno = certno;
}
public Integer getCerttype() {
	return certtype;
}
public void setCerttype(Integer certtype) {
	this.certtype = certtype;
}
 
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}
public Integer getGender() {
	return gender;
}
public void setGender(Integer gender) {
	this.gender = gender;
}
public Integer getBirthday() {
	return birthday;
}
public void setBirthday(Integer birthday) {
	this.birthday = birthday;
}
public Integer getCstmlevel() {
	return cstmlevel;
}
public void setCstmlevel(Integer cstmlevel) {
	this.cstmlevel = cstmlevel;
}
public String getCstmphoto() {
	return cstmphoto;
}
public void setCstmphoto(String cstmphoto) {
	this.cstmphoto = cstmphoto;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getCstmtype() {
	return cstmtype;
}
public void setCstmtype(Integer cstmtype) {
	this.cstmtype = cstmtype;
}
public Integer getRegtime() {
	return regtime;
}
public void setRegtime(Integer regtime) {
	this.regtime = regtime;
}
public Integer getCstmst() {
	return cstmst;
}
public void setCstmst(Integer cstmst) {
	this.cstmst = cstmst;
}
 

	
}
