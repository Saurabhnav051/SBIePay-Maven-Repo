package com.epay.encdata.entity;
import javax.persistence.Column;

public class AggregatorHosted {

	public AggregatorHosted() {
		
	}

	@Column(name ="EncryptTrans")
	protected String encryptTrans;
	
	@Column(name ="EncryptbillingDetails")
	protected String encryptbillingDetails;
	
	@Column(name ="EncryptshippingDetais")
	protected String encryptshippingDetais;
	
	@Column(name ="EncryptpaymentDetails")
	protected String encryptpaymentDetails;
	
	@Column(name ="merchIdVal")
	protected String merchIdVal;
	
	@Column(name ="hiddenMerchantOrderNo")
	protected String hiddenMerchantOrderNo;
	
	@Column(name ="neftRtgsMobileNumber")
	protected String neftRtgsMobileNumber;
	
	@Column(name ="neftRtgsEmailId")
	protected String neftRtgsEmailId;
	
	@Column(name ="neftChallanExpDt")
	protected String neftChallanExpDt;
	
	@Column(name ="cashCustomerName")
	protected String cashCustomerName;

	public String getEncryptTrans() {
		return encryptTrans;
	}

	public void setEncryptTrans(String encryptTrans) {
		this.encryptTrans = encryptTrans;
	}

	public String getEncryptbillingDetails() {
		return encryptbillingDetails;
	}

	public void setEncryptbillingDetails(String encryptbillingDetails) {
		this.encryptbillingDetails = encryptbillingDetails;
	}

	public String getEncryptshippingDetais() {
		return encryptshippingDetais;
	}

	public void setEncryptshippingDetais(String encryptshippingDetais) {
		this.encryptshippingDetais = encryptshippingDetais;
	}

	public String getEncryptpaymentDetails() {
		return encryptpaymentDetails;
	}

	public void setEncryptpaymentDetails(String encryptpaymentDetails) {
		this.encryptpaymentDetails = encryptpaymentDetails;
	}

	public String getMerchIdVal() {
		return merchIdVal;
	}

	public void setMerchIdVal(String merchIdVal) {
		this.merchIdVal = merchIdVal;
	}

	public String getHiddenMerchantOrderNo() {
		return hiddenMerchantOrderNo;
	}

	public void setHiddenMerchantOrderNo(String hiddenMerchantOrderNo) {
		this.hiddenMerchantOrderNo = hiddenMerchantOrderNo;
	}

	public String getNeftRtgsMobileNumber() {
		return neftRtgsMobileNumber;
	}

	public void setNeftRtgsMobileNumber(String neftRtgsMobileNumber) {
		this.neftRtgsMobileNumber = neftRtgsMobileNumber;
	}

	public String getNeftRtgsEmailId() {
		return neftRtgsEmailId;
	}

	public void setNeftRtgsEmailId(String neftRtgsEmailId) {
		this.neftRtgsEmailId = neftRtgsEmailId;
	}

	public String getNeftChallanExpDt() {
		return neftChallanExpDt;
	}

	public void setNeftChallanExpDt(String neftChallanExpDt) {
		this.neftChallanExpDt = neftChallanExpDt;
	}

	public String getCashCustomerName() {
		return cashCustomerName;
	}

	public void setCashCustomerName(String cashCustomerName) {
		this.cashCustomerName = cashCustomerName;
	}

	@Override
	public String toString() {
		return "AggregatorHosted [encryptTrans=" + encryptTrans + ", encryptbillingDetails=" + encryptbillingDetails
				+ ", encryptshippingDetais=" + encryptshippingDetais + ", encryptpaymentDetails="
				+ encryptpaymentDetails + ", merchIdVal=" + merchIdVal + ", hiddenMerchantOrderNo="
				+ hiddenMerchantOrderNo + ", neftRtgsMobileNumber=" + neftRtgsMobileNumber + ", neftRtgsEmailId="
				+ neftRtgsEmailId + ", neftChallanExpDt=" + neftChallanExpDt + ", cashCustomerName=" + cashCustomerName
				+ "]";
	}
	
	
	
	
	


}
