package cn.bjtc.view;

public class ActawardsView  extends Pagination{

	private Integer id;
	private Integer actid;
	private Integer awardtype;//如优惠券、积分、商品
	private String awobj;
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
	public Integer getAwardtype() {
		return awardtype;
	}
	public void setAwardtype(Integer awardtype) {
		this.awardtype = awardtype;
	}
	public String getAwobj() {
		return awobj;
	}
	public void setAwobj(String awobj) {
		this.awobj = awobj;
	}
	
	
}
