package cn.bjtc.view;

public class Pagination {

	private int pageIndex = 1;
	private int pageSize;
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageOffset() {
		return (pageIndex-1)*pageSize;
	}
}
