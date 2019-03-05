package com.entor.springboot3.util;

import java.util.List;

public class Pager<T> {
	public int sp;
	public int pageSize;
	public int pageCounts;
	public int totals;

	
	public List<T> list; 
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Pager() {
		super();
	}
	
	public Pager(int totals,String currentPage,int rows) {
		try {
		  this.sp=Integer.parseInt(currentPage);
		}catch(Exception e) {
			this.sp=1;
		}
		this.pageSize=rows;
		this.totals=totals;
		this.pageCounts=this.totals/pageSize;
		if(this.totals%pageSize!=0) {
			this.pageCounts++;
		}
		if(this.sp>this.pageCounts) {
			this.sp=this.pageCounts;
		}
		if(this.sp<1) {
			this.sp=1;
		}
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCounts() {
		return pageCounts;
	}

	public void setPageCounts(int pageCounts) {
		this.pageCounts = pageCounts;
	}

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}
}
