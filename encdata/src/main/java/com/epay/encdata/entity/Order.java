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
public class Order {

	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "orderid") protected int orderid;
	 */
	
	@Column(name = "ordernumber")
	protected int ordernumber;
	
	//@NotNull(message = "amount can not be null!!")
	//@NotEmpty(message = "amount  can not be empty!!")
	@Column(name ="amount")
	protected int amount;
	

	@Column(name ="merchantid")
	protected String merchantid;
	

	@Column(name ="key")
	protected String key;

	public Order(int ordernumber, int amount,String merchantid,String key) {
		super();
		this.ordernumber = ordernumber;
		this.amount = amount;
		this.merchantid = merchantid;
		this.key = key;
	}

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Order [ordernumber=" + ordernumber + ", amount=" + amount + ", merchantid=" + merchantid + ", key="
				+ key + "]";
	}
	
	
	
	
	
	

	
}
