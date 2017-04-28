package cn.bjtc.view;

import cn.bjtc.api.BaseDictType;
import cn.bjtc.common.ApplicationDataManager;

/**
 * @author Mr.wu
 *
 */
public class SkuView extends Pagination{
	private Integer id;
	private String skuname;
	private String barcode;
	private Double price;
	private Double mktprice;
	private Integer fromsys;
	private Integer sourceid;
	private Integer productid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSkuname() {
		return skuname;
	}
	public void setSkuname(String skuname) {
		this.skuname = skuname;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Integer getFromsys() {
		return fromsys;
	}
	public void setFromsys(Integer fromsys) {
		this.fromsys = fromsys;
	}
	public Integer getSourceid() {
		return sourceid;
	}
	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMktprice() {
		return mktprice;
	}
	public void setMktprice(Double mktprice) {
		this.mktprice = mktprice;
	}
	public String getFromsyStr() {
		return ApplicationDataManager.getDictValueByTypeValue(BaseDictType.DICT_FROMSYS.toString(), String.valueOf(fromsys));
	}
}
