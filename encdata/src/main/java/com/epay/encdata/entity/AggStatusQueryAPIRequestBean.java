package com.epay.encdata.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class AggStatusQueryAPIRequestBean {
	StatusQuery req;

	public StatusQuery getReq() {
		return req;
	}

	public void setReq(StatusQuery req) {
		this.req = req;
	}

	
	  @Override public String toString() { return req+""; }

	public AggStatusQueryAPIRequestBean(StatusQuery req) {
		super();
		this.req = req;
	}

	public AggStatusQueryAPIRequestBean() {
		
	}
	 

	
	
	/*
	 * @Override public String toString() { return " {req=" + req + "}"; }
	 */
	
	
	
	
}
