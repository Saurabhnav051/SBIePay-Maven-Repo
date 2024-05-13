package com.epay.encdata.entity;

public class RefundRequest {
	
	private String merchantId;
	private String aggregatorID;
	private String refundRequestID;
	private String referenceNumber;
	private String refundAmount;
	private String refundAmountCurrency;
	private String rerchantOrderNumber;
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getAggregatorID() {
		return aggregatorID;
	}
	public void setAggregatorID(String aggregatorID) {
		this.aggregatorID = aggregatorID;
	}
	public String getRefundRequestID() {
		return refundRequestID;
	}
	public void setRefundRequestID(String refundRequestID) {
		this.refundRequestID = refundRequestID;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundAmountCurrency() {
		return refundAmountCurrency;
	}
	public void setRefundAmountCurrency(String refundAmountCurrency) {
		this.refundAmountCurrency = refundAmountCurrency;
	}
	public String getRerchantOrderNumber() {
		return rerchantOrderNumber;
	}
	public void setRerchantOrderNumber(String rerchantOrderNumber) {
		this.rerchantOrderNumber = rerchantOrderNumber;
	}
 
	

}
