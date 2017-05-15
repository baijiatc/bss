package cn.bjtc.view;

public class StockView extends Pagination {
	private Integer stockid;
	private Integer productid;
	private Integer skuid;
	private Integer stocknum;
	private Integer minstock;
	private String skuname;
	
	public Integer getStockid() {
		return stockid;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getSkuid() {
		return skuid;
	}
	public void setSkuid(Integer skuid) {
		this.skuid = skuid;
	}
	public Integer getStocknum() {
		return stocknum;
	}
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}
	public Integer getMinstock() {
		return minstock;
	}
	public void setMinstock(Integer minstock) {
		this.minstock = minstock;
	}
	public String getSkuname() {
		return skuname;
	}
	public void setSkuname(String skuname) {
		this.skuname = skuname;
	}
}
