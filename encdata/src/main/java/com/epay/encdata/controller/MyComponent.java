package com.epay.encdata.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

	@Value("${mkValue}")
    private String mkValue;
	
	@Value("${kkValue}")
	private String kkValue;
	
	@Value("${successUrl}")
	private String successUrl;
	
	@Value("${failUrl}")
	private String failUrl;
	
	@Value("${merchantId}")
	private String merchantId;
	@Value("${apiUrl}")
	private String apiUrl;
	@Value("${checksumMethod}")
	private String checksumMethod;
	
	@Value("${TransactionUrl}")
	private String TransactionUrl;
	
	@Value("${queryAPIUrl}")
	private String queryAPIUrl;
	
	@Value("${operatingMode}")
	private String operatingMode;
	
	@Value("${merchantCountry}")
	private String merchantCountry;
	
	@Value("${merchantCurrency}")
	private String merchantCurrency;
	
	@Value("${otherDetails}")
	private String otherDetails;
	
	@Value("${aggregatorId}")
	private String aggregatorId;
	
	@Value("${paymode}")
	private String paymode;
	
	@Value("${accessMedium}")
	private String accessMedium;
	
	@Value("${transactionSource}")
	private String transactionSource;
	
	@Value("${encryptionMethod}")
	private String encryptionMethod;
	
	@Value("${refundApiUrl}")
	private String refundApiUrl;
	
	@Value("${statusQueryAPI}")
	private String statusQueryAPI;
	
	@Value("${transactionMISAPI}")
	private String transactionMISAPI;
	
	@Value("${transactionPayoutAPI}")
	private String transactionPayoutAPI;
	
	
	public String getMkValue() {
		return mkValue;
	}

	public String getKkValue() {
		return kkValue;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public String getFailUrl() {
		return failUrl;
	}

	public String getMerchantId() {
		return merchantId;
	}
	public String getapiUrl() {
		return apiUrl;
	}
	
	public String getchecksumMethod() {
		return checksumMethod;
	}

	public String getTransactionUrl() {
		return TransactionUrl;
	}

	public void setTransactionUrl(String TransactionUrl) {
		this.TransactionUrl = TransactionUrl;
	}

	public String getQueryAPIUrl() {
		return queryAPIUrl;
	}

	public void setQueryAPIUrl(String queryAPIUrl) {
		this.queryAPIUrl = queryAPIUrl;
	}

	public String getOperatingMode() {
		return operatingMode;
	}

	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}

	public String getMerchantCountry() {
		return merchantCountry;
	}

	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}

	public String getMerchantCurrency() {
		return merchantCurrency;
	}

	public void setMerchantCurrency(String merchantCurrency) {
		this.merchantCurrency = merchantCurrency;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public String getAggregatorId() {
		return aggregatorId;
	}

	public void setAggregatorId(String aggregatorId) {
		this.aggregatorId = aggregatorId;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public String getAccessMedium() {
		return accessMedium;
	}

	public void setAccessMedium(String accessMedium) {
		this.accessMedium = accessMedium;
	}

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getEncryptionMethod() {
		return encryptionMethod;
	}

	public void setEncryptionMethod(String encryptionMethod) {
		this.encryptionMethod = encryptionMethod;
	}

	public String getRefundApiUrl() {
		return refundApiUrl;
	}

	public void setRefundApiUrl(String refundApiUrl) {
		this.refundApiUrl = refundApiUrl;
	}

	public String getStatusQueryAPI() {
		return statusQueryAPI;
	}

	public void setStatusQueryAPI(String statusQueryAPI) {
		this.statusQueryAPI = statusQueryAPI;
	}

	public String getChecksumMethod() {
		return checksumMethod;
	}

	public void setChecksumMethod(String checksumMethod) {
		this.checksumMethod = checksumMethod;
	}

	public String getTransactionMISAPI() {
		return transactionMISAPI;
	}

	public void setTransactionMISAPI(String transactionMISAPI) {
		this.transactionMISAPI = transactionMISAPI;
	}

	public String getTransactionPayoutAPI() {
		return transactionPayoutAPI;
	}

	public void setTransactionPayoutAPI(String transactionPayoutAPI) {
		this.transactionPayoutAPI = transactionPayoutAPI;
	}

	
	
}
