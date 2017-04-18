package cn.bjtc.view;

public class MoneyflowView extends Pagination {
	private Integer id;
	private Integer flowno;
	private Integer departid;
	private Integer fromsys;
	private double total;
	private String account;
	private Integer selftime;
	private Integer direction;
	private Integer createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFlowno() {
		return flowno;
	}
	public void setFlowno(Integer flowno) {
		this.flowno = flowno;
	}
	public Integer getDepartid() {
		return departid;
	}
	public void setDepartid(Integer departid) {
		this.departid = departid;
	}
	public Integer getFromsys() {
		return fromsys;
	}
	public void setFromsys(Integer fromsys) {
		this.fromsys = fromsys;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getSelftime() {
		return selftime;
	}
	public void setSelftime(Integer selftime) {
		this.selftime = selftime;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public Integer getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
}
