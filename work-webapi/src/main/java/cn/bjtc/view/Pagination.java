package cn.bjtc.view;

import java.io.Serializable;

public class Pagination implements Serializable {

	private int pageIndex = 1;
	private int pageSize = 10;
	
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
		if(pageIndex == 0){
			pageIndex = 1;
		}
		return (pageIndex-1)*pageSize;
	}
}
