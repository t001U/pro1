package com.yyj.entity;

public class RolesEntity {
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getDBCONNECT() {
		return DBCONNECT;
	}

	public void setDBCONNECT(String dBCONNECT) {
		DBCONNECT = dBCONNECT;
	}

	private String NAME;
	
	private String DESCRIPTION;
	
	private String DBCONNECT;
}
