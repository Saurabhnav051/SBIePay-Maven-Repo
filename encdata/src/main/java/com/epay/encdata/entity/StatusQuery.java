package com.epay.encdata.entity;

import javax.persistence.Column;

public class StatusQuery {

	
	@Column(name="atrn")
	protected String atrn;
	//@Column(name="aggregatorId")
	//protected String aggregatorId;
	@Column(name="merchantId")
	protected String merchantId;
	@Column(name="merchOrderNo")
	protected String merchOrderNo;
	@Column(name="amount")
	protected String amount;
	@Column(name="sourceUrl")
	protected String sourceUrl;
	public String getAtrn() {
		return atrn;
	}
	public void setAtrn(String atrn) {
		this.atrn = atrn;
	}
//	public String getAggregatorId() {
//		return aggregatorId;
//	}
//	public void setAggregatorId(String aggregatorId) {
//		this.aggregatorId = aggregatorId;
//	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchOrderNo() {
		return merchOrderNo;
	}
	public void setMerchOrderNo(String merchOrderNo) {
		this.merchOrderNo = merchOrderNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	
	public StatusQuery(String atrn,String merchantId, String merchOrderNo, String amount,
			String sourceUrl) {
		super();
		this.atrn = atrn;
		//this.aggregatorId = aggregatorId;
		this.merchantId = merchantId;
		this.merchOrderNo = merchOrderNo;
		this.amount = amount;
		this.sourceUrl = sourceUrl;
	}
	
	
	
	/*
	 * @Override public String toString() { return "{req:{atrn=" + atrn +
	 * ", merchantId=" + merchantId + ", merchOrderNo=" + merchOrderNo + ", amount="
	 * + amount + ", sourceUrl=" + sourceUrl + "}}"; }
	 */
	
	
	/*
	 * @Override public String toString() { return "{req:{atrn=" + atrn +
	 * ", merchantId=" + merchantId + ", merchOrderNo=" + merchOrderNo + ", amount="
	 * + amount + ", sourceUrl=" + sourceUrl + "}}"; }
	 */
	 
	public StatusQuery() {
		// TODO Auto-generated constructor stub
		
		
	}
//	@Override
//	public String toString() {
//		return "[atrn=" + atrn + ", merchantId=" + merchantId + ", merchOrderNo=" + merchOrderNo
//				+ ", amount=" + amount + ", sourceUrl=" + sourceUrl + "]";
//	}
	
	
	
	
	
	

}
