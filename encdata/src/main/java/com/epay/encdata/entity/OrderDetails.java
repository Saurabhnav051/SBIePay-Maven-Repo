package com.epay.encdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*@Setter
@Getter
@ToString*/
public class OrderDetails extends Order{

	public OrderDetails(int ordernumber, int amount,
			@NotNull(message = "amount can not be null!!") @NotEmpty(message = "amount  can not be empty!!") String merchantid,
			@NotNull(message = "amount can not be null!!") @NotEmpty(message = "amount  can not be empty!!") String key) {
		super(ordernumber, amount, merchantid, key);
		// TODO Auto-generated constructor stub
	}

	@Column(name ="operatingMode",columnDefinition ="varchar(255) default 'DOM'")
	protected String operatingMode="DOM";
		
	@Column(name ="MerchantCountry")
	protected String MerchantCountry="IN";
	
	@Column(name ="MerchantCurrency")
	protected String MerchantCurrency="INR";
	
	@Column(name ="OtherDetails")
	protected String OtherDetails="Other";
	
	@Column(name ="SuccessURL")
	protected String SuccessURL="https://test.sbiepay.sbi/secure/sucess3.jsp";
	
	@Column(name ="FailURL")
	protected String FailURL="https://test.sbiepay.sbi /secure/fail3.jsp";
	
	@Column(name ="AggregatorId")
	protected String AggregatorId="SBIEPAY";
	
	@Column(name ="MerchantOrderNumber")
	protected String MerchantOrderNumber;
	
	@Column(name ="MerchantCustomerID")
	protected String MerchantCustomerID;
	
	@Column(name ="Paymode")
	protected String Paymode="NB";
	
	@Column(name ="AccessMedium")
	protected String AccessMedium="ONLINE";
	
	@Column(name ="TransactionSourc")
	protected String TransactionSourc="ONLINE";

	public String getOperatingMode() {
		return operatingMode;
	}

	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}

	public String getMerchantCountry() {
		return MerchantCountry;
	}

	public void setMerchantCountry(String merchantCountry) {
		MerchantCountry = merchantCountry;
	}

	public String getMerchantCurrency() {
		return MerchantCurrency;
	}

	public void setMerchantCurrency(String merchantCurrency) {
		MerchantCurrency = merchantCurrency;
	}

	public String getOtherDetails() {
		return OtherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		OtherDetails = otherDetails;
	}

	public String getSuccessURL() {
		return SuccessURL;
	}

	public void setSuccessURL(String successURL) {
		SuccessURL = successURL;
	}

	public String getFailURL() {
		return FailURL;
	}

	public void setFailURL(String failURL) {
		FailURL = failURL;
	}

	public String getAggregatorId() {
		return AggregatorId;
	}

	public void setAggregatorId(String aggregatorId) {
		AggregatorId = aggregatorId;
	}

	public String getMerchantOrderNumber() {
		return MerchantOrderNumber;
	}

	public void setMerchantOrderNumber(String merchantOrderNumber) {
		MerchantOrderNumber = merchantOrderNumber;
	}

	public String getMerchantCustomerID() {
		return MerchantCustomerID;
	}

	public void setMerchantCustomerID(String merchantCustomerID) {
		MerchantCustomerID = merchantCustomerID;
	}

	public String getPaymode() {
		return Paymode;
	}

	public void setPaymode(String paymode) {
		Paymode = paymode;
	}

	public String getAccessMedium() {
		return AccessMedium;
	}

	public void setAccessMedium(String accessMedium) {
		AccessMedium = accessMedium;
	}

	public String getTransactionSourc() {
		return TransactionSourc;
	}

	public void setTransactionSourc(String transactionSourc) {
		TransactionSourc = transactionSourc;
	}

	@Override
	public String toString() {
		return "OrderDetails [operatingMode=" + operatingMode + ", MerchantCountry=" + MerchantCountry
				+ ", MerchantCurrency=" + MerchantCurrency + ", OtherDetails=" + OtherDetails + ", SuccessURL="
				+ SuccessURL + ", FailURL=" + FailURL + ", AggregatorId=" + AggregatorId + ", MerchantOrderNumber="
				+ MerchantOrderNumber + ", MerchantCustomerID=" + MerchantCustomerID + ", Paymode=" + Paymode
				+ ", AccessMedium=" + AccessMedium + ", TransactionSourc=" + TransactionSourc + "]";
	}
	
	
	
	
	
	
}
