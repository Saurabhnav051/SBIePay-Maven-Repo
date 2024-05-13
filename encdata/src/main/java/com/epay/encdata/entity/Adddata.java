package com.epay.encdata.entity;

import javax.persistence.Column;

/*@Setter
@Getter
@ToString*/
public class Adddata {

	
	@Column(name ="number1")
	protected int number1;
	
	@Column(name ="number2")
	protected int number2;

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "Adddata [number1=" + number1 + ", number2=" + number2 + "]";
	}
	
	
	
}