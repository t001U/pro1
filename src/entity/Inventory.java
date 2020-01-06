package com.entity;
/**
 * 盘存报损表实体类
 * @author Administrator
 *
 */
public class Inventory {

	private int ID;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getDRUGID() {
		return DRUGID;
	}

	public void setDRUGID(String dRUGID) {
		DRUGID = dRUGID;
	}

	public String getBATCHID() {
		return BATCHID;
	}

	public void setBATCHID(String bATCHID) {
		BATCHID = bATCHID;
	}

	public String getCNAME() {
		return CNAME;
	}

	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}

	public String getSPEC() {
		return SPEC;
	}

	public void setSPEC(String sPEC) {
		SPEC = sPEC;
	}

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}

	public int getJOBPRICE() {
		return JOBPRICE;
	}

	public void setJOBPRICE(int jOBPRICE) {
		JOBPRICE = jOBPRICE;
	}

	public int getSALEPRICE() {
		return SALEPRICE;
	}

	public void setSALEPRICE(int sALEPRICE) {
		SALEPRICE = sALEPRICE;
	}

	public int getNUMBER() {
		return NUMBER;
	}

	public void setNUMBER(int nUMBER) {
		NUMBER = nUMBER;
	}

	public int getREALNUMBER() {
		return REALNUMBER;
	}

	public void setREALNUMBER(int rEALNUMBER) {
		REALNUMBER = rEALNUMBER;
	}

	public int getDOWNLIMIT() {
		return DOWNLIMIT;
	}

	public void setDOWNLIMIT(int dOWNLIMIT) {
		DOWNLIMIT = dOWNLIMIT;
	}

	public int getUPLIMIT() {
		return UPLIMIT;
	}

	public void setUPLIMIT(int uPLIMIT) {
		UPLIMIT = uPLIMIT;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}

	public String getTIMELIMIT() {
		return TIMELIMIT;
	}

	public void setTIMELIMIT(String tIMELIMIT) {
		TIMELIMIT = tIMELIMIT;
	}

	public String getPROVIDER() {
		return PROVIDER;
	}

	public void setPROVIDER(String pROVIDER) {
		PROVIDER = pROVIDER;
	}

	public String getEVENTTIME() {
		return EVENTTIME;
	}

	public void setEVENTTIME(String eVENTTIME) {
		EVENTTIME = eVENTTIME;
	}

	public String getCAUSE() {
		return CAUSE;
	}

	public void setCAUSE(String cAUSE) {
		CAUSE = cAUSE;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	public String getINPUTCODE1() {
		return INPUTCODE1;
	}

	public void setINPUTCODE1(String iNPUTCODE1) {
		INPUTCODE1 = iNPUTCODE1;
	}

	private String CODE;
	
	private String DRUGID;
	
	private String BATCHID;
	
	private String CNAME;
	
	private String SPEC;
	
	private String UNIT;
	
	private int JOBPRICE;
	
	private int SALEPRICE;
	
	private int NUMBER;
	
	private int REALNUMBER;
	
	private int DOWNLIMIT;
	
	private int UPLIMIT;
	
	private int TYPE;
	
	private String TIMELIMIT;
	
	private String PROVIDER;
	
	private String EVENTTIME;
	
	private String CAUSE;
	
	private int STATE;
	
	private String INPUTCODE1;
}
