package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

public class OrderView extends Pagination {

	private Integer id;
	private String orderno;
	private Integer orderst;
	private Integer fromsys;
	private Double totalfee;
	private Double payment;
	private Double totalpay;
	private Double discountfee;
	private Double pointsfee;
	private Double platformpay;
	private Double refundfee;
	private Integer ordertype;
	private Integer buyer;
	private Integer saler;
	private Integer paytype;
	private Integer orderdt;
	private Integer cstmcontactid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Integer getOrderst() {
		return orderst;
	}
	public void setOrderst(Integer orderst) {
		this.orderst = orderst;
	}
	public Integer getFromsys() {
		return fromsys;
	}
	public void setFromsys(Integer fromsys) {
		this.fromsys = fromsys;
	}
	public Double getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Double getTotalpay() {
		return totalpay;
	}
	public void setTotalpay(Double totalpay) {
		this.totalpay = totalpay;
	}
	public Double getDiscountfee() {
		return discountfee;
	}
	public void setDiscountfee(Double discountfee) {
		this.discountfee = discountfee;
	}
	public Double getPointsfee() {
		return pointsfee;
	}
	public void setPointsfee(Double pointsfee) {
		this.pointsfee = pointsfee;
	}
	public Double getPlatformpay() {
		return platformpay;
	}
	public void setPlatformpay(Double platformpay) {
		this.platformpay = platformpay;
	}
	public Double getRefundfee() {
		return refundfee;
	}
	public void setRefundfee(Double refundfee) {
		this.refundfee = refundfee;
	}
	public Integer getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(Integer ordertype) {
		this.ordertype = ordertype;
	}
	public Integer getBuyer() {
		return buyer;
	}
	public void setBuyer(Integer buyer) {
		this.buyer = buyer;
	}
	public Integer getSaler() {
		return saler;
	}
	public void setSaler(Integer saler) {
		this.saler = saler;
	}
	public Integer getPaytype() {
		return paytype;
	}
	public void setPaytype(Integer paytype) {
		this.paytype = paytype;
	}
	public Integer getOrderdt() {
		return orderdt;
	}
	public void setOrderdt(Integer orderdt) {
		this.orderdt = orderdt;
	}
	public Integer getCstmcontactid() {
		return cstmcontactid;
	}
	public void setCstmcontactid(Integer cstmcontactid) {
		this.cstmcontactid = cstmcontactid;
	}
	public String getOrderStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ORDER.toString(), String.valueOf(orderst));
	}
	public String getOrdertypeStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_ORDERTYPE.toString(), String.valueOf(ordertype));
	}
	public String getPaytypeStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_PAYTYPE.toString(), String.valueOf(paytype));
	}
	public String getFromsyStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_FROMSYS.toString(), String.valueOf(fromsys));
	}
}
