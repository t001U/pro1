package com.Word_Test.dao.entity;
/**
 * 理财产品实体类
 * @author Administrator
 *
 */
public class Frinancingproduct {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getSaleStarting() {
		return saleStarting;
	}

	public void setSaleStarting(String saleStarting) {
		this.saleStarting = saleStarting;
	}

	public String getSaleEnd() {
		return saleEnd;
	}

	public void setSaleEnd(String saleEnd) {
		this.saleEnd = saleEnd;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	private String id;
	
	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	private String risk;
	
	private String income;
	
	private String saleStarting;
	
	private String saleEnd;
	
	private String end;
}
