package cn.bjtc.view;

public class BrandView extends Pagination{

	    private Integer id;
	    private String brandname;
	    private String brandalias;//品牌别称
	    private String weburl;
	    private String branddesc;
	    private String brandlogo;
	    private Integer sort;//排序
	    private Integer brandst;//1-正常，0-失效
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getBrandname() {
			return brandname;
		}
		public void setBrandname(String brandname) {
			this.brandname = brandname;
		}
		public String getBrandalias() {
			return brandalias;
		}
		public void setBrandalias(String brandalias) {
			this.brandalias = brandalias;
		}
		public String getWeburl() {
			return weburl;
		}
		public void setWeburl(String weburl) {
			this.weburl = weburl;
		}
		public String getBranddesc() {
			return branddesc;
		}
		public void setBranddesc(String branddesc) {
			this.branddesc = branddesc;
		}
		public String getBrandlogo() {
			return brandlogo;
		}
		public void setBrandlogo(String brandlogo) {
			this.brandlogo = brandlogo;
		}
		public Integer getSort() {
			return sort;
		}
		public void setSort(Integer sort) {
			this.sort = sort;
		}
		public Integer getBrandst() {
			return brandst;
		}
		public void setBrandst(Integer brandst) {
			this.brandst = brandst;
		}
	 
}
