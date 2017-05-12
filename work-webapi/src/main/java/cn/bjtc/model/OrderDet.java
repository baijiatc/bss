package cn.bjtc.model;

public class OrderDet {

	private Integer id;
	private Integer orderid;
	private Integer skuid;
	private double price;
	private double payment;
	private double totalpay;
	private double discountfee;
	private double pointsfee;
	private double platformpay;
	private double refundfee;
	private String skuname;
	private Integer num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getSkuid() {
		return skuid;
	}
	public void setSkuid(Integer skuid) {
		this.skuid = skuid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getTotalpay() {
		return totalpay;
	}
	public void setTotalpay(double totalpay) {
		this.totalpay = totalpay;
	}
	public double getDiscountfee() {
		return discountfee;
	}
	public void setDiscountfee(double discountfee) {
		this.discountfee = discountfee;
	}
	public double getPointsfee() {
		return pointsfee;
	}
	public void setPointsfee(double pointsfee) {
		this.pointsfee = pointsfee;
	}
	public double getPlatformpay() {
		return platformpay;
	}
	public void setPlatformpay(double platformpay) {
		this.platformpay = platformpay;
	}
	public double getRefundfee() {
		return refundfee;
	}
	public void setRefundfee(double refundfee) {
		this.refundfee = refundfee;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSkuname() {
		return skuname;
	}
	public void setSkuname(String skuname) {
		this.skuname = skuname;
	}
}
