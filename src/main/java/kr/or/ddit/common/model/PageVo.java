package kr.or.ddit.common.model;

public class PageVo {
	private int page;
	private int pageSize;
	private int bor_no;
	
	
	public int getBor_no() {
		return bor_no;
	}

	public void setBor_no(int bor_no) {
		this.bor_no = bor_no;
	}

	public PageVo() {}
	
	public PageVo(int page, int pageSize, int bor_no) {
		this.page=page;
		this.pageSize= pageSize;
		this.bor_no=bor_no;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
}
