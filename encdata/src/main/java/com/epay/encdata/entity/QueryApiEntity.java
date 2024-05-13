package com.epay.encdata.entity;


public class QueryApiEntity {

	protected String encData;
	protected String cs;
	protected String merchantCode;
	public String getEncData() {
		return encData;
	}
	public void setEncData(String encData) {
		this.encData = encData;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	@Override
	public String toString() {
		return "QueryApiRequest [encData=" + encData + ", cs=" + cs + ", merchantCode=" + merchantCode + "]";
	}
	public String getchecksumMethod() {
		return cs;
	}
	public void setChecksumMethod(String cs) {
		this.cs = cs;
	}
	
}
