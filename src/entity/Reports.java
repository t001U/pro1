package com.entity;
/**
 * 药店统计表实体类
 * @author Administrator
 *
 */
public class Reports {
	
	private String GUID;

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String gUID) {
		GUID = gUID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getALIAS() {
		return ALIAS;
	}

	public void setALIAS(String aLIAS) {
		ALIAS = aLIAS;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getLANDSCAPE() {
		return LANDSCAPE;
	}

	public void setLANDSCAPE(int lANDSCAPE) {
		LANDSCAPE = lANDSCAPE;
	}

	public String getPRINTER() {
		return PRINTER;
	}

	public void setPRINTER(String pRINTER) {
		PRINTER = pRINTER;
	}

	public String getEXPLAIN() {
		return EXPLAIN;
	}

	public void setEXPLAIN(String eXPLAIN) {
		EXPLAIN = eXPLAIN;
	}

	public String getDEFINE() {
		return DEFINE;
	}

	public void setDEFINE(String dEFINE) {
		DEFINE = dEFINE;
	}

	public String getFCTIME() {
		return FCTIME;
	}

	public void setFCTIME(String fCTIME) {
		FCTIME = fCTIME;
	}

	public String getLMTIME() {
		return LMTIME;
	}

	public void setLMTIME(String lMTIME) {
		LMTIME = lMTIME;
	}

	private String NAME;
	
	private String ALIAS;
	
	private int WIDTH;
	
	private int HEIGHT;
	
	private int LANDSCAPE;
	
	private String PRINTER;
	
	private String EXPLAIN;
	
	private String DEFINE;
	
	private String FCTIME;
	
	private String LMTIME;
}
