package com.gzeinnumer.mybasecode.base.response;

import com.google.gson.annotations.SerializedName;

public class Info {

	@SerializedName("next")
	private int next;

	@SerializedName("total")
	private int total;

	@SerializedName("totalPage")
	private int totalPage;

	@SerializedName("prev")
	private int prev;

	@SerializedName("page")
	private int page;

	public int getNext(){
		return next;
	}

	public int getTotal(){
		return total;
	}

	public int getTotalPage(){
		return totalPage;
	}

	public int getPrev(){
		return prev;
	}

	public int getPage(){
		return page;
	}
}