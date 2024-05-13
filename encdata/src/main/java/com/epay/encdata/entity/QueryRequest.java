package com.epay.encdata.entity;

public class QueryRequest {

	private String queryRequest;
	private String aggregatorId;
	private String merchantId;
	
	public String getQueryRequest() {
		return queryRequest;
	}
	public void setQueryRequest(String queryRequest) {
		this.queryRequest = queryRequest;
	}
	public String getAggregatorId() {
		return aggregatorId;
	}
	public void setAggregatorId(String aggregatorId) {
		this.aggregatorId = aggregatorId;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	
}
