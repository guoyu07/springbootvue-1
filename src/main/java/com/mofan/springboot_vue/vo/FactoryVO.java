package com.mofan.springboot_vue.vo;

import com.mofan.springboot_vue.persistence.DateVO;

public class FactoryVO extends DateVO<FactoryVO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String phone;
	private String creditCode;
	private String legal;
	private String afterSaleHotline;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getAfterSaleHotline() {
		return afterSaleHotline;
	}

	public void setAfterSaleHotline(String afterSaleHotline) {
		this.afterSaleHotline = afterSaleHotline;
	}

	

}
