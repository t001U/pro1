package com.Drug.entity;

public class Acl {

	private String pobject;
	
	private String privileger;
	
	private int pType;
	
	private int pValue;

	public String getPobject() {
		return pobject;
	}

	public void setPobject(String pobject) {
		this.pobject = pobject;
	}

	public String getPrivileger() {
		return privileger;
	}

	public void setPrivileger(String privileger) {
		this.privileger = privileger;
	}

	public int getpType() {
		return pType;
	}

	public void setpType(int pType) {
		this.pType = pType;
	}

	public int getpValue() {
		return pValue;
	}

	public void setpValue(int pValue) {
		this.pValue = pValue;
	}
}
